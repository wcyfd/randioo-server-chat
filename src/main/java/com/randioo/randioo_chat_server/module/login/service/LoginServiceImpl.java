package com.randioo.randioo_chat_server.module.login.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_chat_server.common.ErrorCode;
import com.randioo.randioo_chat_server.db.dao.RoleDao;
import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_chat_server.protocol.Login.LoginCheckAccountRequest;
import com.randioo.randioo_chat_server.protocol.Login.LoginCheckAccountResponse;
import com.randioo.randioo_chat_server.protocol.Login.LoginCreateRoleRequest;
import com.randioo.randioo_chat_server.protocol.Login.LoginCreateRoleResponse;
import com.randioo.randioo_chat_server.protocol.Login.LoginGetRoleDataRequest;
import com.randioo.randioo_chat_server.protocol.Login.LoginGetRoleDataResponse;
import com.randioo.randioo_chat_server.protocol.Login.RoleData;
import com.randioo.randioo_chat_server.protocol.ServerMessage.SCMessage;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.entity.RoleInterface;
import com.randioo.randioo_server_base.module.login.LoginHandler;
import com.randioo.randioo_server_base.module.login.LoginModelServiceImpl;
import com.randioo.randioo_server_base.utils.TimeUtils;
import com.randioo.randioo_server_base.utils.template.Ref;

public class LoginServiceImpl extends LoginModelServiceImpl implements LoginService {

	private RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void init() {
		// 初始化所有已经有过的帐号和昵称
		List<List> lists = roleDao.getAllAccounts$Names();
		for (List list : lists) {
			RoleCache.getAccountSet().add((String) list.get(0));
			RoleCache.getNameSet().add((String) list.get(1));
		}
		setLoginHandler(new LoginHandlerImpl());
	}

	private class LoginHandlerImpl implements LoginHandler {

		@Override
		public boolean checkLoginAccountCanLogin(String account, Ref<Object> canLoginErrorMessage) {
			return true;
		}

		@Override
		public String getLoginAccount(Object loginMessage) {
			LoginCheckAccountRequest request = (LoginCheckAccountRequest) loginMessage;
			return request.getAccount();
		}

		@Override
		public GeneratedMessage isNewAccount(String account) {
			return SCMessage
					.newBuilder()
					.setLoginCheckAccountResponse(
							LoginCheckAccountResponse
									.newBuilder()
									.setErrorCode(
											RoleCache.getAccountSet().contains(account) ? ErrorCode.SUCCESS : ErrorCode.SHORT_TWO))
					.build();
		}

		@Override
		public String getCreateRoleAccount(Object createRoleMessage) {
			LoginCreateRoleRequest request = (LoginCreateRoleRequest) createRoleMessage;
			return request.getAccount();
		}

		@Override
		public boolean checkCreateRoleAccount(Object createRoleMessage, Ref<Object> checkCreateRoleMessage) {
			LoginCreateRoleRequest request = (LoginCreateRoleRequest) createRoleMessage;

			if (RoleCache.getNameSet().contains(request.getName())) {

				checkCreateRoleMessage.set(SCMessage
						.newBuilder()
						.setLoginCreateRoleResponse(
								LoginCreateRoleResponse.newBuilder().setErrorCode(ErrorCode.NAME_IS_ALREADY_HAS))
						.build());
				return false;
			}

			if (RoleCache.getAccountSet().contains(request.getAccount())) { // 判定账号是否存在

				checkCreateRoleMessage.set(SCMessage
						.newBuilder()
						.setLoginCreateRoleResponse(
								LoginCreateRoleResponse.newBuilder().setErrorCode(ErrorCode.ACCOUNT_IS_ALREADY_HAS))
						.build());
				return false;
			}
			return true;
		}

		@Override
		public Connection getConnection() throws SQLException {
			return dataSource.getConnection();
		}

		@Override
		public Object createRole(Connection conn, Object createRoleMessage) {
			LoginCreateRoleRequest request = (LoginCreateRoleRequest) createRoleMessage;

			// 用户数据
			Role role = roleInit(request.getAccount(), conn, request.getName());

			// 加入role缓存
			RoleCache.putNewRole(role);

			return SCMessage.newBuilder()
					.setLoginCreateRoleResponse(LoginCreateRoleResponse.newBuilder().setErrorCode(ErrorCode.SUCCESS))
					.build();
		}

		@Override
		public GeneratedMessage getRoleData(Ref<RoleInterface> ref) {
			Role role = (Role) ref.get();
			RoleData.Builder roleDataBuilder = RoleData.newBuilder().setRoleId(role.getRoleId())
					.setName(role.getName()).setAccount(role.getAccount());
			return SCMessage
					.newBuilder()
					.setLoginGetRoleDataResponse(
							LoginGetRoleDataResponse.newBuilder().setErrorCode(ErrorCode.SUCCESS)
									.setServerTime(TimeUtils.getNowTime()).setRoleData(roleDataBuilder)).build();
		}

		@Override
		public String getRoleDataAccount(Object createRoleMessage) {
			LoginGetRoleDataRequest request = (LoginGetRoleDataRequest) createRoleMessage;
			return request.getAccount();
		}

		@Override
		public boolean getRoleObject(Ref<RoleInterface> ref, Object createRoleMessage,
				Ref<Object> errorMessage) {
			LoginGetRoleDataRequest request = (LoginGetRoleDataRequest) createRoleMessage;
			String account = request.getAccount();
			Role role = (Role) RoleCache.getRoleByAccount(account);
			if (role == null) {
				role = roleDao.getRoleByAccount(account);
				loginRoleModuleDataInit(role);
				if (role == null) {
					errorMessage.set(SCMessage
							.newBuilder()
							.setLoginGetRoleDataResponse(
									LoginGetRoleDataResponse.newBuilder().setErrorCode(ErrorCode.NO_ROLE)).build());
					return false;
				}
			}
			ref.set(role);

			return true;
		}

		@Override
		public boolean connectingError(Ref<Object> errorConnectingMessage) {
			errorConnectingMessage
					.set(SCMessage
							.newBuilder()
							.setLoginGetRoleDataResponse(
									LoginGetRoleDataResponse.newBuilder().setErrorCode(ErrorCode.IN_LOGIN)).build());
			return true;
		}

	}

	/**
	 * 初始化用户数据
	 * 
	 * @param account
	 * @param conn
	 * @return
	 */
	private Role roleInit(String account, Connection conn, String name) {
		// 创建用户
		Role role = new Role();
		role.setAccount(account);
		role.setName(name);		

		int id = roleDao.insertRole(role, conn);
		role.setRoleId(id);

		return role;
	}

	@Override
	public void loginRoleModuleDataInit(Role role) {
		// 将数据库中的数据放入缓存中
		RoleCache.putRoleCache(role);
	}
}
