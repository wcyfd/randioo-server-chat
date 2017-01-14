package com.randioo.randioo_chat_server.module.chat.action;

import org.apache.mina.core.session.IoSession;

import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_chat_server.module.chat.service.ChatService;
import com.randioo.randioo_chat_server.protocol.Chat.ChatExitChatRoomRequest;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(ChatExitChatRoomRequest.class)
public class ChatExitChatRoomAction extends ActionSupport {
	private ChatService chatService;

	public void setChatService(ChatService chatService) {
		this.chatService = chatService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		ChatExitChatRoomRequest request = (ChatExitChatRoomRequest) data;
		Role role = (Role) RoleCache.getRoleBySession(session);
		chatService.exitChatRoom(role, request.getRoomId(), session);
	}

}
