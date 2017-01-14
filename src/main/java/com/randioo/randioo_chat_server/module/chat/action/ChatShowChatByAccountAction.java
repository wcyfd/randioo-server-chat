package com.randioo.randioo_chat_server.module.chat.action;

import org.apache.mina.core.session.IoSession;

import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_chat_server.module.chat.service.ChatService;
import com.randioo.randioo_chat_server.protocol.Chat.ChatShowAccountChatRequest;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(ChatShowAccountChatRequest.class)
public class ChatShowChatByAccountAction extends ActionSupport {
	private ChatService chatService;

	public void setChatService(ChatService chatService) {
		this.chatService = chatService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		ChatShowAccountChatRequest request = (ChatShowAccountChatRequest) data;
		Role role = (Role) RoleCache.getRoleBySession(session);
		chatService.showChatByAccount(role, request.getAccount());
	}

}
