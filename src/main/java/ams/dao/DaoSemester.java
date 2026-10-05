package ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import com.mysql.cj.protocol.Resultset;

import ams.model.ModelSemester;
import ams.util.DBConnection;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

public class DaoSemester {
	public static int saveSemester(ModelSemester me) {
		int i=0;
		try {
			Connection conn=DBConnection.getConnection();
			String query="INSERT INTO semester_master(sem_code,sem_name,year_code)value(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, me.getSem_code());
			ps.setString(2, me.getSem_name());
			ps.setString(3, me.getYear_code());
			i=ps.executeUpdate();
			conn.close();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public static List<ModelSemester> getAllSemester(){
		List<ModelSemester>list=new ArrayList<ModelSemester>();
		try {
			Connection conn=DBConnection.getConnection();
			String query="Select * from semester_master";
			PreparedStatement ps=conn.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int sem_id=rs.getInt("sem_id");
				String sem_code=rs.getString("sem_code");
				String sem_name=rs.getString("sem_name");
				String year_code=rs.getString("year_code");
				ModelSemester me=new ModelSemester();
				me.setSem_id(sem_id);
				me.setSem_code(sem_code);
				me.setSem_name(sem_name);
				me.setYear_code(year_code);
				list.add(me);
				
				
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static ModelSemester getBySemesterId(int sem_id) {
		ModelSemester me=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="Select * from semester_master WHERE sem_id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, sem_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int sem_id1=rs.getInt("sem_id");
				String sem_code=rs.getString("sem_code");
				String sem_name=rs.getString("sem_name");
				String year_code=rs.getString("year_code");
				me=new ModelSemester();
				me.setSem_id(sem_id1);
				me.setSem_code(sem_code);
				me.setSem_name(sem_name);
				me.setYear_code(year_code);
				
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return me;
		
	}
	public static int UpdateSemester(String sem_code,String sem_name,String year_code,int sem_id) {
		int i=0;
		try {
			Connection conn=DBConnection.getConnection();
			String query="Update semester_master set sem_code=?,sem_name=?,year_code=? where sem_id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, sem_code);
			ps.setString(2, sem_name);
			ps.setString(3, year_code);
			ps.setInt(4, sem_id);
			i=ps.executeUpdate();
			conn.close();
			ps.close();
			
		} catch (Exception e) {
			
		}
		return i;
	}

}
