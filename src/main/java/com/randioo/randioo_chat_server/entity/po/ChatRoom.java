package com.randioo.randioo_chat_server.entity.po;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChatRoom {
	private String roomId;
	private Lock lock = new ReentrantLock();
	/** 房间内的玩家 */
	private Set<String> roleAccountSet = new HashSet<>();

	public Lock getLock() {
		return lock;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Set<String> getRoleSet() {
		return roleAccountSet;
	}

}
