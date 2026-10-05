package ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import ams.model.ModelStudent;
import ams.model.ModelSubject;
import ams.util.DBConnection;

public class DaoSubject {
	public static int saveSubject(ModelSubject ms) {
		int i=0;
		try {
			Connection conn=DBConnection.getConnection();
			String query="INSERT INTO subject_master(sub_name,sem_code,sub_code,dept_code)value(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,ms.getSub_name());
			ps.setString(2,ms.getSem_code());
			ps.setString(3,ms.getSub_code());
			ps.setString(4,ms.getDept_code());
			i=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public static List<ModelSubject> getallSubject() {
		List<ModelSubject>list=new ArrayList<ModelSubject>();
		try {
			Connection conn=DBConnection.getConnection();
			String query="select sm.*,se.sem_name,dp.dept_name from subject_master as sm,semester_master as se,department_master as dp where sm.sem_code=se.sem_code and sm.dept_code=dp.dept_code;";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ModelSubject ms=new ModelSubject();
				int sub_id=rs.getInt("sub_id");
				String sub_name=rs.getString("sub_name");
				String sem_code=rs.getString("sem_code");
				String sub_code=rs.getString("sub_code");
				String dept_code=rs.getString("dept_code");
				String sem_name=rs.getString("sem_name");
				String dept_name=rs.getString("dept_name");
				ms.setSub_id(sub_id);
				ms.setSub_name(sub_name);
				ms.setSem_code(sem_code);
				ms.setSub_code(sub_code);
				ms.setDept_code(dept_code);
				ms.setDept_name(dept_name);
				ms.setSem_name(sem_name);
				
				list.add(ms);
			}
			conn.close();
			ps.close();
			rs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		
		
	}
		return list;

}
	public static ModelSubject getSubjectById(int sub_id) {
	ModelSubject ms=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="Select * from subject_master Where sub_id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, sub_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ms=new ModelSubject();
				int sub_id1=rs.getInt("sub_id");
				String sub_name=rs.getString("sub_name");
				String sem_code=rs.getString("sem_code");
				String sub_code=rs.getString("sub_code");
				String dept_code=rs.getString("dept_code");
				ms.setSub_id(sub_id1);
				ms.setSub_name(sub_name);
				ms.setSem_code(sem_code);
				ms.setSub_code(sub_code);
				ms.setDept_code(dept_code);
				
				
			}
			conn.close();
			ps.close();
			rs.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ms;
	
	}
	public static int updateSubject(String sub_name,String sem_code,String sub_code,String dept_code,int sub_id) {
		int i=0;
		try {
			Connection conn=DBConnection.getConnection();
			String query="Update subject_master set sub_name=?,sem_code=?,sub_code=?,dept_code=? where sub_id=? ";
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1, sub_name);
			ps.setString(2, sem_code);
			ps.setString(3, sub_code);
			ps.setString(4, dept_code);
			ps.setInt(5, sub_id);
			i=ps.executeUpdate();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public static List<ModelSubject> getSubjectByStudent(ModelStudent st) {
		List<ModelSubject> lms = new ArrayList<ModelSubject>();
		try {
			Connection conn=DBConnection.getConnection();
			String query="Select * from subject_master Where sem_code=? and dept_code = ?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, st.getSem_code());
			ps.setString(2, st.getDept_code());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ModelSubject ms=new ModelSubject();
				int sub_id1=rs.getInt("sub_id");
				String sub_name=rs.getString("sub_name");
				String sem_code=rs.getString("sem_code");
				String sub_code=rs.getString("sub_code");
				String dept_code=rs.getString("dept_code");
				ms.setSub_id(sub_id1);
				ms.setSub_name(sub_name);
				ms.setSem_code(sem_code);
				ms.setSub_code(sub_code);
				ms.setDept_code(dept_code);
				
				lms.add(ms);
			}
			conn.close();
			ps.close();
			rs.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return lms;
	}

	
}
