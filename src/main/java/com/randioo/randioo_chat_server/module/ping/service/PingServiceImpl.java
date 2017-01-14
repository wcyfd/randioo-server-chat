package com.randioo.randioo_chat_server.module.ping.service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_chat_server.protocol.Ping.PingResponse;
import com.randioo.randioo_chat_server.protocol.ServerMessage.SCMessage;
import com.randioo.randioo_server_base.module.BaseService;
import com.randioo.randioo_server_base.utils.TimeUtils;

public class PingServiceImpl extends BaseService implements PingService {

	@Override
	public GeneratedMessage ping(Role role, long clientTime) {
		return SCMessage
				.newBuilder()
				.setPingResponse(
						PingResponse.newBuilder().setServerTimestamp(TimeUtils.getNowTime())
								.setClientTimestamp(clientTime)).build();
	}

}
