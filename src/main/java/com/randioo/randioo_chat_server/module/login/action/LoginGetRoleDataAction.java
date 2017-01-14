package com.randioo.randioo_chat_server.module.login.action;

import org.apache.mina.core.session.IoSession;

import com.randioo.randioo_chat_server.module.login.service.LoginService;
import com.randioo.randioo_chat_server.protocol.Login.LoginGetRoleDataRequest;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(LoginGetRoleDataRequest.class)
public class LoginGetRoleDataAction extends ActionSupport {

	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		// TODO Auto-generated method stub
		Object sc = loginService.getRoleData(data, session);
		
		if (sc != null) {
			session.write(sc);
		}

	}

}
