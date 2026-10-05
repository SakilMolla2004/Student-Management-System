package ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import ams.model.ModelTeacher;
import ams.util.DBConnection;

public class DaoTeacher {
	public static int saveTeacher(ModelTeacher mt) {
		int i=0;
		try {
			Connection conn=DBConnection.getConnection();
			String query="INSERT INTO teacher_table (sub_code,t_name,gender,image)value(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, mt.getSub_code());
			ps.setString(2,mt.getT_name());
			ps.setString(3, mt.getGender());
			ps.setString(4, mt.getImage());
			System.out.println(mt.getImage());
			i=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}
	public static List<ModelTeacher> getAllTeacher() {
		List<ModelTeacher> list=new ArrayList<ModelTeacher>();
		try {
			Connection conn=DBConnection.getConnection();
			String query="Select * from teacher_table";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ModelTeacher mt=new ModelTeacher();
				int t_id=rs.getInt("t_id");
				String sub_code=rs.getString("sub_code");
				String t_name=rs.getString("t_name");
				String gender=rs.getString("gender");
				String image=rs.getString("image");
				mt.setT_id(t_id);
				mt.setSub_code(sub_code);
				mt.setT_name(t_name);
				mt.setGender(gender);
				mt.setImage(image);
				list.add(mt);
			}
			conn.close();
			ps.close();
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static ModelTeacher getTeacherById(int t_id) {
		ModelTeacher mt=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="Select * from teacher_table where t_id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, t_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				mt=new ModelTeacher();
			int t_id1=rs.getInt("t_id");
			String sub_code=rs.getString("sub_code");
			String t_name=rs.getString("t_name");
			String gender=rs.getString("gender");
			mt.setT_id(t_id1);
			mt.setSub_code(sub_code);
			mt.setT_name(t_name);
			mt.setGender(gender);
			}
			ps.close();
			rs.close();
			conn.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return mt;
	}
	public static int updateTeacher(String sub_code,String t_name,String gender,int t_id) {
		int i=0;
		{
			try {
				Connection conn=DBConnection.getConnection();
				String query="Update teacher_table set sub_code=?,t_name=?,gender=? where t_id=?";
				PreparedStatement ps=conn.prepareStatement(query);
				ps.setString(1, sub_code);
				ps.setString(2, t_name);
				ps.setString(3, gender);
				ps.setInt(4, t_id);
				i=ps.executeUpdate();
				conn.close();
				ps.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		return i;
		
	}
	public static ModelTeacher getTeacherBySubjetCode(String psub_code) {
		ModelTeacher mt=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="Select * from teacher_table where sub_code=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, psub_code);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				mt=new ModelTeacher();
			int t_id1=rs.getInt("t_id");
			String sub_code=rs.getString("sub_code");
			String t_name=rs.getString("t_name");
			String gender=rs.getString("gender");
			mt.setT_id(t_id1);
			mt.setSub_code(sub_code);
			mt.setT_name(t_name);
			mt.setGender(gender);
			}
			ps.close();
			rs.close();
			conn.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return mt;
	}

}
