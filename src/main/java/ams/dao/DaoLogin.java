package ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ams.model.ModelUser;
import ams.util.DBConnection;

public class DaoLogin {
	public static ModelUser authenticate(String userName, String password, String role) {
		String tableName = "";
		ModelUser u = null;
		try {
			if(role.equals("teacher")) {
				tableName ="admin";
			}
			else if(role.equals("student")) {
				tableName ="student_table";
			}
			else if(role.equals("superadmin")) {
				tableName ="saregistration";
			}
			Connection conn = DBConnection.getConnection();
			String query = "Select * from "+tableName+" where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				u = new ModelUser();
				u.setEmail(rs.getString("email"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setUsername(rs.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}
}
