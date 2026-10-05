package ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import ams.model.ModelStudent;
import ams.util.DBConnection;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

public class DaoStudent {
	public static int saveStudent(ModelStudent st) {
		int i=0;
		try {
			Connection conn =DBConnection.getConnection();
			String query="INSERT INTO student_table(sem_code,name,gender,address,dept_code,image) value(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, st.getSem_code());
			ps.setString(2, st.getName());
			ps.setString(3, st.getGender());
			ps.setString(4, st.getAddress());
			ps.setString(5, st.getDept_code());
			ps.setString(6, st.getImage());
			i=ps.executeUpdate();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
		e.printStackTrace();	
		}
		return i;
	}
	public static List<ModelStudent> getAllStudent(){
		List<ModelStudent> list=new ArrayList<ModelStudent>();
		try {
			Connection conn=DBConnection.getConnection();
			String query="SELECT st.*, dm.dept_name, sm.sem_name FROM student_table as st, department_master as dm, semester_master as sm where st.dept_code = dm.dept_code and sm.sem_code = st.sem_code";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int s_id=rs.getInt("s_id");
				String sem_code=rs.getString("sem_code");
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				String address=rs.getString("address");
				String dept_code=rs.getString("dept_code");
				String dept_name = rs.getString("dept_name");
				String sem_name = rs.getString("sem_name");
				ModelStudent st=new ModelStudent();
				st.setS_id(s_id);
				st.setSem_code(sem_code);
				st.setName(name);
				st.setGender(gender);
				st.setAddress(address);
				st.setDept_code(dept_code);
				st.setDept_name(dept_name);
				st.setSem_name(sem_name);
				list.add(st);
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}
	public static ModelStudent getStudentById(int s_id) {
		ModelStudent st=null;
		try {
			Connection conn=DBConnection.getConnection();
			String  query="Select * from student_table where s_id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, s_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int s_id1=rs.getInt("s_id");
				String sem_code=rs.getString("sem_code");
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				String address=rs.getString("address");
				String dept_code=rs.getString("dept_code");
				st=new ModelStudent();
				st.setS_id(s_id1);
				st.setSem_code(sem_code);
				st.setName(name);
				st.setGender(gender);
				st.setAddress(address);
				st.setDept_code(dept_code);
				
				
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
		
	}
	public static int updateStudent(String sem_code,String name,String gender,String address,String dept_code,int s_id) {
		int i=0;
		try {
		Connection conn	=DBConnection .getConnection();
		String query="Update student_table set sem_code=?,name=?,gender=?,address=?,dept_code=? where s_id=?";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1, sem_code);
		ps.setString(2, name);
		ps.setString(3, gender);
		ps.setString(4, address);
		ps.setString(5, dept_code);
		ps.setInt(6, s_id);
		i=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
	
