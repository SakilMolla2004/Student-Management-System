package ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import ams.model.ModelAdmin;
import ams.model.ModelUser;
import ams.util.DBConnection;

public class DaoAdmin {
	public static List<ModelAdmin> getAllDataByTeachers(String Name) {
		List<ModelAdmin> list = new ArrayList<ModelAdmin>();

		try {

			Connection conn = DBConnection.getConnection();
			String query = "SELECT sm.sub_name,sm.sem_code,sm.dept_code FROM subject_master as sm where sub_name IN(select sub_code from teacher_table where t_name in(select name from admin where username=?))";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, Name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String sub_name = rs.getString("sub_name");
				String sem_code = rs.getString("sem_code");
				String dept_code = rs.getString("dept_code");
				ModelAdmin ma = new ModelAdmin();
				ma.setSub_name(sub_name);
				ma.setSem_code(sem_code);
				ma.setDept_code(dept_code);
				list.add(ma);
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	public static ModelAdmin getImageByTeacherName(String Name) {
		ModelAdmin ma=new ModelAdmin();
		try {
			Connection conn=DBConnection.getConnection();
			String query="SELECT image , t_name FROM teacher_table where t_name in(Select name from admin where username=?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, Name);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				String image=rs.getString("image");
				ma.setImage(image);
				
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ma;
	}

}
