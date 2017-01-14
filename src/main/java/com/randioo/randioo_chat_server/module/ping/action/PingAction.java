package com.randioo.randioo_chat_server.module.ping.action;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_chat_server.module.ping.service.PingService;
import com.randioo.randioo_chat_server.protocol.Ping.PingRequest;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(PingRequest.class)
public class PingAction extends ActionSupport {
	private PingService pingService;

	public void setPingService(PingService pingService) {
		this.pingService = pingService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		PingRequest request = (PingRequest) data;
		Role role = (Role) RoleCache.getRoleBySession(session);
		GeneratedMessage message = pingService.ping(role, request.getClientTimestamp());
		if (message != null) {
			session.write(message);
		}
	}
}
