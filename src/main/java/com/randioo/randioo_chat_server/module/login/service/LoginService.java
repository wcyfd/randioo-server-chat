package com.randioo.randioo_chat_server.module.login.service;

import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_server_base.module.login.LoginModelService;

public interface LoginService extends LoginModelService{
	public void loginRoleModuleDataInit(Role role);
}
