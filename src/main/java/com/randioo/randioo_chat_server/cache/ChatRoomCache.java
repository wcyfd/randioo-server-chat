package com.randioo.randioo_chat_server.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.randioo.randioo_chat_server.entity.po.ChatRoom;

public class ChatRoomCache {

	private static Lock lock = new ReentrantLock();
	/** 游戏聊天 */
	private static Map<String, ChatRoom> gameChatMap = new HashMap<>();
	/** 私人聊天 */
	private static Map<String, ChatRoom> privateChatMap = new HashMap<>();

	public static Lock getLock() {
		return lock;
	}

	public static Map<String, ChatRoom> getRoomCache() {
		return gameChatMap;
	}

	public static ChatRoom getChatRoomById(String roomId) {
		return gameChatMap.get(roomId);
	}

	public static Map<String, ChatRoom> getPrivateChatMap() {
		return privateChatMap;
	}

	public static ChatRoom getPrivateChatRoomById(String privateRoomId) {
		return privateChatMap.get(privateRoomId);
	}
}
