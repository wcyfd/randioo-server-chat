package com.randioo.randioo_chat_server.db.converter;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.randioo.randioo_chat_server.entity.bo.Role;
import com.randioo.randioo_server_base.db.converter.ResultConverter;

public class RoleConverter implements ResultConverter<Role> {

	public Role convert(ResultSet rs) throws SQLException {
		Role role = new Role();

		role.setRoleId(rs.getInt("id"));
		role.setAccount(rs.getString("account"));
		role.setName(rs.getString("name"));

		return role;
	}
}
