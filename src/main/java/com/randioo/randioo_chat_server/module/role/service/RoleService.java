package com.randioo.randioo_chat_server.module.role.service;

import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface RoleService extends BaseServiceInterface {
	public Role getRoleByAccount(String account);

	public Role getRoleById(int roleId);
}
