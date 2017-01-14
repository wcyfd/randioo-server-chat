package com.randioo.randioo_chat_server.entity.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.randioo.randioo_server_base.entity.RoleInterface;
import com.randioo.randioo_server_base.module.chat.Chatable;
import com.randioo.randioo_server_base.utils.db.Saveable;

public class AbstractRole implements RoleInterface, Chatable, Saveable {

	private String account;
	private String name;
	private int roleId;

	@Override
	public String getAccount() {
		// TODO Auto-generated method stub
		return account;
	}

	@Override
	public void setAccount(String account) {
		// TODO Auto-generated method stub
		this.account = account;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public int getRoleId() {
		// TODO Auto-generated method stub
		return roleId;
	}

	@Override
	public void setRoleId(int roleId) {
		// TODO Auto-generated method stub
		this.roleId = roleId;
	}

	private boolean change;

	@Override
	public void setChange(boolean change) {
		// TODO Auto-generated method stub
		this.change = change;
	}

	@Override
	public boolean isChange() {
		// TODO Auto-generated method stub
		return change;
	}

	@Override
	public boolean checkChange() {
		// TODO Auto-generated method stub
		return change;
	}

	private Map<String, List<Object>> historyChatMap = new HashMap<>();

	@Override
	public Map<String, List<Object>> getHistoryChatMap() {
		// TODO Auto-generated method stub
		return historyChatMap;
	}

	
	private Map<String,Integer> unreadChatCountMap = new HashMap<>();
	@Override
	public Map<String, Integer> getUnreadChatCountMap() {
		// TODO Auto-generated method stub
		return unreadChatCountMap;
	}


//	private Map<String, List<Object>> unreadChatMap = new HashMap<>();
//
//	@Override
//	public Map<String, List<Object>> getUnreadChatMap() {
//		// TODO Auto-generated method stub
//		return unreadChatMap;
//	}

}
