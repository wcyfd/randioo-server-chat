package com.randioo.randioo_chat_server.module.role.service;

import com.randioo.randioo_chat_server.db.dao.RoleDao;
import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_chat_server.module.login.service.LoginService;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.module.BaseService;

public class RoleServiceImpl extends BaseService implements RoleService {
	private RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public Role getRoleByAccount(String account) {
		Role role = (Role) RoleCache.getRoleByAccount(account);
		if (role == null) {
			role = roleDao.getRoleByAccount(account);
			if (role != null) {
				loginService.loginRoleModuleDataInit(role);
				return role;
			}

		}
		return null;
	}

	@Override
	public Role getRoleById(int roleId) {
		Role role = (Role) RoleCache.getRoleById(roleId);
		if (role == null) {
			role = roleDao.getRoleById(roleId);
			if (role != null) {
				loginService.loginRoleModuleDataInit(role);
				return role;
			}
		}
		return null;
	}
}
