package com.randioo.randioo_chat_server.module.chat.service;

import org.apache.mina.core.session.IoSession;

import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

/**
 * 聊天服务
 * 
 * @author wcy 2016年12月19日
 *
 */	
public interface ChatService extends BaseServiceInterface {

	public void enterChatRoom(Role role, String roomId, IoSession session);

	public void exitChatRoom(Role role, String roomId, IoSession session);

	public void showChatByAccount(Role role, String account);

	public void sendChat(Role role, String roomId, String context, IoSession session);

	public void sendPrivateChat(Role role, String account, String context, IoSession session);

	public void showSummaryChatInfo(Role role);

	public void offline(Role role);
}
