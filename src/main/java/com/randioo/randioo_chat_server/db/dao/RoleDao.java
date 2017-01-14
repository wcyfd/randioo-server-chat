package com.randioo.randioo_chat_server.db.dao;

import java.sql.Connection;
import java.util.List;

import com.randioo.randioo_chat_server.entity.bo.Role;

public interface RoleDao {
	/**
	 * 新建用户
	 * @param role
	 */
	public int insertRole(Role role,Connection conn);
	
	/**
	 * 获得所有玩家
	 * @return
	 */
	public List<Role> getAllRole();
	
	public Role getRoleByAccount(String account);
	
	public void updateRole(Role role);

	Role getRoleById(int id);

	List<List> getAllAccounts$Names();
}
