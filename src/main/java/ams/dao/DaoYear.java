package ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import ams.model.ModelYear;
import ams.util.DBConnection;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

public class DaoYear {
	public static int SaveYear(ModelYear my) {
		int i=0;
		try {
			Connection conn=DBConnection.getConnection();
			String query="INSERT INTO year_master_course (year_name,year_code)value(?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,my.getYear_name());
			ps.setString(2, my.getYear_code());
			i=ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}
	public static List<ModelYear> getAllYears(){
		List<ModelYear> list=new ArrayList<ModelYear>();
		try {
			Connection conn=DBConnection.getConnection();
			String query="Select * from year_master_course";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();	
			while(rs.next()) {
				ModelYear my=new ModelYear();
				int y_id=rs.getInt("y_id");
				String year_name=rs.getString("year_name");
				String year_code=rs.getString("year_code");
				my.setY_id(y_id);
				my.setYear_name(year_name);
				my.setYear_code(year_code);
				list.add(my);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static ModelYear getYearById(int y_id) {
		ModelYear my=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="Select * from year_master_course where y_id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, y_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				my=new ModelYear();
				int y_id1=rs.getInt("y_id");
				String year_name=rs.getString("year_name");
				String year_code=rs.getString("year_code");
				my.setY_id(y_id1);
				my.setYear_name(year_name);
				my.setYear_code(year_code);
				
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return my;
	}
	public static int updateYear(String year_name,String year_code,int y_id) {
		int i=0;
		try {
			Connection conn=DBConnection.getConnection();
			String query="Update year_master_course set year_name=?,year_code=? where y_id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, year_name);
			ps.setString(2, year_code);
			ps.setInt(3, y_id);
			i=ps.executeUpdate();
			conn.close();
			ps.close();
			
		} catch (Exception e) {
		e.printStackTrace();	
		}
		return i;
	}

}
