package com.randioo.randioo_chat_server.module.ping.service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface PingService extends BaseServiceInterface{
	public GeneratedMessage ping(Role role,long clientTime);
}
