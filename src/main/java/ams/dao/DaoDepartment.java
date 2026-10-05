package ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ams.model.ModelDashboard;
import ams.model.ModelDepartment;
import ams.util.DBConnection;

public class DaoDepartment {
	public static List<ModelDepartment> getAlldepartment() {
		List<ModelDepartment> list = new ArrayList<ModelDepartment>();
		try {
			Connection conn = DBConnection.getConnection();
			String query = "Select * from department_master";
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ModelDepartment md = new ModelDepartment();
				int dept_id = rs.getInt("dept_id");
				String dept_code = rs.getString("dept_code");
				String dept_name = rs.getString("dept_name");

				md.setDept_id(dept_id);
				md.setDept_code(dept_code);
				md.setDept_name(dept_name);

				list.add(md);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;

	}

	public static int saveDepartment(ModelDepartment md) {
		int i = 0;
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "INSERT INTO department_master (dept_name,dept_code) VALUES (?, ?)";
			PreparedStatement rd = conn.prepareStatement(sql);
			rd.setString(1, md.getDept_name());
			rd.setString(2, md.getDept_code());
			i = rd.executeUpdate();

			conn.close();
			rd.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public static ModelDepartment getDepartmentById(int dept_id) {
		ModelDepartment md = null;
		try {
			Connection conn = DBConnection.getConnection();
			String query = "Select * from department_master where dept_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, dept_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				md = new ModelDepartment();
				int dept_id_x = rs.getInt("dept_id");
				String dept_code = rs.getString("dept_code");
				String dept_name = rs.getString("dept_name");
				md.setDept_id(dept_id_x);
				md.setDept_code(dept_code);
				md.setDept_name(dept_name);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return md;
	}

	public static int updateDept(String deptname, String deptcode, int deptid) {
		int i = 0;
		try {
			Connection conn = DBConnection.getConnection();
			String query = "Update department_master set dept_name = ?, dept_code = ? where dept_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, deptname);
			ps.setString(2, deptcode);
			ps.setInt(3, deptid);
			i = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public static ModelDashboard count() {
		ModelDashboard mod=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="SELECT count(dept_id) AS count_dept FROM department_master";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				mod=new ModelDashboard();
				int count_dept=rs.getInt("count_dept");
				mod.setCount_dept(count_dept);
				
			}
			
			ps.close();
			rs.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mod;
		
	}
	public static ModelDashboard countSub() {
		ModelDashboard mod=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="SELECT count(distinct sub_name) AS count_sub FROM subject_master;";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				mod=new ModelDashboard();
				int count_sub=rs.getInt("count_sub");
				mod.setCount_sub(count_sub);
				
			}
			
			ps.close();
			rs.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mod;
		
	}
	public static ModelDashboard countTeacher() {
		ModelDashboard mod=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="SELECT count( distinct t_name) AS count_teacher FROM teacher_table";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				mod=new ModelDashboard();
				int count_teacher=rs.getInt("count_teacher");
				mod.setCount_teacher(count_teacher);
				
			}
			
			ps.close();
			rs.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mod;
		
	}
	public static ModelDashboard countSem() {
		ModelDashboard mod=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="SELECT count(distinct sem_code) as count_sem FROM semester_master";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				mod=new ModelDashboard();
				int count_sem=rs.getInt("count_sem");
				mod.setCount_sem(count_sem);
				
			}
			
			ps.close();
			rs.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mod;
		
	}
	public static ModelDashboard countYear() {
		ModelDashboard mod=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="SELECT count(distinct year_name) as count_year FROM year_master_course";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				mod=new ModelDashboard();
				int count_year=rs.getInt("count_year");
				mod.setCount_year(count_year);
				
			}
			
			ps.close();
			rs.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mod;
		
	}
	public static ModelDashboard countStudent() {
		ModelDashboard mod=null;
		try {
			Connection conn=DBConnection.getConnection();
			String query="SELECT count(distinct s_id) as count_student FROM student_table";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				mod=new ModelDashboard();
				int count_student=rs.getInt("count_student");
				mod.setCount_student(count_student);
				
			}
			
			ps.close();
			rs.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mod;
		
	}
	

}
