package com.randioo.randioo_chat_server;

import com.randioo.randioo_chat_server.db.dao.RoleDao;
import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_chat_server.module.chat.service.ChatService;
import com.randioo.randioo_server_base.cache.SessionCache;
import com.randioo.randioo_server_base.net.SpringContext;

/**
 * session关闭角色数据处理
 * 
 */
public class SessionCloseHandler {

	/**
	 * 移除session缓存
	 * 
	 * @param id
	 */
	public static void manipulate(Role role) {
		System.out.println("[account:" + role.getAccount() + ",name:" + role.getName() + "] manipulate");

		SessionCache.removeSessionById(role.getRoleId());

		ChatService chatService = SpringContext.getBean("chatService");

		chatService.offline(role);

		updateRoleData(role);
	}

	public static void updateRoleData(Role role) {
		try {
			RoleDao roleDao = (RoleDao) SpringContext.getBean("roleDao");

			if (role.isChange()) {
				roleDao.updateRole(role);
				role.setChange(false);
			}

			System.out.println("[account:" + role.getAccount() + " name:" + role.getName() + "] manipulate Success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("role:" + role.getAccount() + " save error");
		}

	}
}
