package ams.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import ams.model.ModelStudent;
import ams.util.DBConnection;

public class DaoStudents {
	public static ModelStudent getStudents(String userName) {
		ModelStudent ms = new ModelStudent();
		try {
			Connection conn = DBConnection.getConnection();
			String query = "SELECT s.name,s.gender,s.address, s.dept_code,s.sem_code ,s.image FROM student_table  as s  where username=?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String sem_code = rs.getString("sem_code");
				String dept_code = rs.getString("dept_code");
				String image=rs.getString("image");
				
				ms.setName(name);
				ms.setGender(gender);
				ms.setAddress(address);
				ms.setDept_code(dept_code);
				ms.setSem_code(sem_code);
				ms.setImage(image);
				

			}
			ps.close();
			rs.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ms;

	}

	public static List<ModelStudent> getAllStudents(String userName) {
		List<ModelStudent> list = new ArrayList<ModelStudent>();

		try {
			Connection conn = DBConnection.getConnection();
			String query = "SELECT DISTINCT  sm.sub_name, t.t_name FROM subject_master sm JOIN student_table st ON sm.sem_code = st.sem_code AND sm.dept_code = st.dept_code JOIN teacher_table t ON t.sub_code = sm.sub_name WHERE st.username = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String sub_name = rs.getString("sub_name");
				String t_name = rs.getString("t_name");

				ModelStudent ms = new ModelStudent();

				ms.setT_name(t_name);
				ms.setSub_name(sub_name);

				list.add(ms);

			}
			ps.close();
			rs.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

}
