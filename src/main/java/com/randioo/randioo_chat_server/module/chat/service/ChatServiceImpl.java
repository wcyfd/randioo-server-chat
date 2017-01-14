package com.randioo.randioo_chat_server.module.chat.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.mina.core.session.IoSession;

import com.randioo.randioo_chat_server.cache.ChatRoomCache;
import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_chat_server.entity.po.ChatRoom;
import com.randioo.randioo_chat_server.module.chat.ChatConstant;
import com.randioo.randioo_chat_server.module.role.service.RoleService;
import com.randioo.randioo_chat_server.protocol.Chat.ChatEnterChatRoomResponse;
import com.randioo.randioo_chat_server.protocol.Chat.ChatInfo;
import com.randioo.randioo_chat_server.protocol.Chat.ChatSendChatResponse;
import com.randioo.randioo_chat_server.protocol.Chat.ChatSendPrivateChatResponse;
import com.randioo.randioo_chat_server.protocol.Chat.ChatShowAccountChatResponse;
import com.randioo.randioo_chat_server.protocol.Chat.ChatShowSummaryResponse;
import com.randioo.randioo_chat_server.protocol.Chat.ChatSummaryInfo;
import com.randioo.randioo_chat_server.protocol.Chat.SCChatReceiveChat;
import com.randioo.randioo_chat_server.protocol.ServerMessage.SCMessage;
import com.randioo.randioo_server_base.cache.SessionCache;
import com.randioo.randioo_server_base.entity.RoleInterface;
import com.randioo.randioo_server_base.module.BaseService;
import com.randioo.randioo_server_base.module.chat.ChatHandler;
import com.randioo.randioo_server_base.module.chat.ChatModelService;
import com.randioo.randioo_server_base.module.chat.Chatable;
import com.randioo.randioo_server_base.utils.TimeUtils;

public class ChatServiceImpl extends BaseService implements ChatService {

	private RoleService roleService;

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	private ChatModelService chatModelService;

	public void setChatModelService(ChatModelService chatModelService) {
		this.chatModelService = chatModelService;
	}

	@Override
	public void init() {
		chatModelService.init();
		chatModelService.setChatHandler(new ChatHandler() {

			@Override
			public Object parseToProtocolMessage(String account, Object baseChatBody) {
				return SCMessage.newBuilder()
						.setScChatReceiveChat(SCChatReceiveChat.newBuilder().setChatInfo((ChatInfo) baseChatBody))
						.build();
			}

			@Override
			public RoleInterface getRoleInterfaceByAccount(String account) {
				return roleService.getRoleByAccount(account);
			}

			@Override
			public Set<String> getNeedSendAccountSet(RoleInterface role, String account, int sendType) {
				if (sendType == ChatConstant.PRIVATE) {
					//私人聊天，则是帐号
					Set<String> accountSet = new HashSet<>();
					accountSet.add(role.getAccount());
					accountSet.add(account);
					return accountSet;

				} else if (sendType == ChatConstant.PUBLIC) {
					
					ChatRoom chatRoom = ChatRoomCache.getChatRoomById(account);
					if (chatRoom == null)
						return null;
					chatRoom.getLock().lock();
					try {
						Set<String> set = new HashSet<>();
						set.addAll(chatRoom.getRoleSet());

						return set;
					} finally {
						chatRoom.getLock().unlock();
					}
				}
				return null;
			}

			@Override
			public Chatable getChatableByAccount(String account) {
				return roleService.getRoleByAccount(account);
			}

			@Override
			public Object getChatInfo(RoleInterface role, String context, int sendType) {
				ChatInfo chatInfo = ChatInfo.newBuilder().setAccount(role.getAccount()).setContext(context)
						.setName(role.getName()).setTime(TimeUtils.getNowTime()).build();
				return chatInfo;
			}

			@Override
			public void showUnreadChatByAccount(RoleInterface roleInterface, String account, List<Object> objList) {
				ChatShowAccountChatResponse.Builder builder = ChatShowAccountChatResponse.newBuilder();
				for (Object obj : objList) {
					ChatInfo chatInfo = (ChatInfo) obj;
					builder.addChatInfos(chatInfo);
				}

				IoSession session = SessionCache.getSessionById(roleInterface.getRoleId());
				session.write(SCMessage.newBuilder().setChatShowAccountChatResponse(builder).build());
			}
		});
	}

	@Override
	public void enterChatRoom(Role role, String roomId, IoSession session) {
		session.write(SCMessage.newBuilder().setChatEnterChatRoomResponse(ChatEnterChatRoomResponse.newBuilder())
				.build());

		ChatRoom chatRoom = ChatRoomCache.getChatRoomById(roomId);
		if (chatRoom == null) {
			ChatRoomCache.getLock().lock();
			try {
				chatRoom = ChatRoomCache.getChatRoomById(roomId);
				if (chatRoom == null) {
					chatRoom = new ChatRoom();
					chatRoom.setRoomId(roomId);
					ChatRoomCache.getRoomCache().put(roomId, chatRoom);
				}
			} finally {
				ChatRoomCache.getLock().unlock();
			}

		}

		chatRoom.getLock().lock();
		try {
			chatRoom.getRoleSet().add(role.getAccount());
		} finally {
			chatRoom.getLock().unlock();
		}

	}

	@Override
	public void exitChatRoom(Role role, String roomId, IoSession session) {
		if (session != null) {
			session.write(SCMessage.newBuilder().setChatEnterChatRoomResponse(ChatEnterChatRoomResponse.newBuilder())
					.build());
		}

		ChatRoom chatRoom = ChatRoomCache.getRoomCache().get(roomId);
		chatRoom.getLock().lock();
		try {
			chatRoom.getRoleSet().remove(role.getAccount());
		} finally {
			chatRoom.getLock().unlock();
		}
	}

	@Override
	public void sendChat(Role role, String roomId, String context, IoSession session) {
		session.write(SCMessage.newBuilder().setChatSendChatResponse(ChatSendChatResponse.newBuilder()).build());

		chatModelService.sendChat(role, role, roomId, context, ChatConstant.PRIVATE);

	}

	@Override
	public void sendPrivateChat(Role role, String account, String context, IoSession session) {

		session.write(SCMessage.newBuilder().setChatSendPrivateChatResponse(ChatSendPrivateChatResponse.newBuilder())
				.build());
		chatModelService.sendChat(role, role, account, context, ChatConstant.PUBLIC);
	}

	/**
	 * 
	 * @param role
	 * @param account
	 * @param session
	 * @author wcy 2016年12月21日
	 */
	@Override
	public void showChatByAccount(Role role, String account) {
		chatModelService.showChatByAccount(role, role, account);
	}

	/**
	 * 显示客户端的聊天概要
	 * 
	 * @param role
	 * @param session
	 * @author wcy 2016年12月21日
	 */
	@Override
	public void showSummaryChatInfo(Role role) {
		ChatShowSummaryResponse.Builder chatShowSummaryResponseBuilder = ChatShowSummaryResponse.newBuilder();
		Map<String, Integer> unreadChatMap = role.getUnreadChatCountMap();
		for (Map.Entry<String, Integer> entrySet : unreadChatMap.entrySet()) {
			String account = entrySet.getKey();
			Integer unreadCount = entrySet.getValue();
			chatShowSummaryResponseBuilder.addChatSummaryInfos(ChatSummaryInfo.newBuilder().setAccount(account)
					.setChatInfoCount(unreadCount));
		}
		IoSession session = SessionCache.getSessionById(role.getRoleId());
		session.write(SCMessage.newBuilder().setChatShowSummaryResponse(chatShowSummaryResponseBuilder).build());
	}

	@Override
	public void offline(Role role) {
		// 一旦掉线所有房间都删除此人
		Map<String, ChatRoom> map = ChatRoomCache.getRoomCache();
		for (ChatRoom chatRoom : map.values()) {
			this.exitChatRoom(role, chatRoom.getRoomId(), null);
		}
	}

}
