package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Department;
import entity.Employee;

public class StudentDao {
	Connection conn;
	Statement stat;

	private void getStatement() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		// 3 建立连接
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/company", "root", "123456");

		// 4 建立sql执行器
		stat = conn.createStatement();
	}

	// 1 在书写代码之外，创建项目后，在bulid path中添加jar包
	public List<Employee> searchAll() {
		List<Employee> list = new ArrayList<Employee>();
		// 2 用反射的机制，加载驱动
		try {
			getStatement();
			// 5 执行sql语句
			ResultSet rs = stat
					.executeQuery("select stu.*,bj.name as bjName from student as stu left join banji as bj on bj_id=bj.id");
			// 6处理结果
			while (rs.next()) {
				Employee stu = new Employee();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setGender(rs.getString("gender"));
				stu.setAge(rs.getInt("age"));
				Department bj = new Department();
				bj.setId(rs.getInt("bj_id"));
				bj.setName(rs.getString("bjName"));
				stu.setBj(bj);
				list.add(stu);
			}
			// 7关闭连接
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 1 在书写代码之外，创建项目后，在bulid path中添加jar包
	public Employee searchById(int id) {
		Employee stu = new Employee();
		// 2 用反射的机制，加载驱动
		try {
			getStatement();
			// 5 执行sql语句
			ResultSet rs = stat.executeQuery("select * from student where id="
					+ id);
			// 6处理结果
			while (rs.next()) {
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setGender(rs.getString("gender"));
				stu.setAge(rs.getInt("age"));
			}
			// 7关闭连接
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}

	public boolean add(Employee stu) {
		boolean flag = false; // 2 用反射的机制，加载驱动
		try {
			getStatement();

			// 5 执行sql语句
			String sql = "insert into student(name,gender,age) values ('"
					+ stu.getName() + "','" + stu.getGender() + "',"
					+ stu.getAge() + ")";
			int rs = stat.executeUpdate(sql);
			// 6处理结果
			if (rs > 0) {

				flag = true;
			}
			// 7关闭连接
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(Employee stu) {
		boolean flag = false; // 2 用反射的机制，加载驱动
		try {
			getStatement();

			// 5 执行sql语句
			String sql = "update student set name='" + stu.getName()
					+ "',gender='" + stu.getGender() + "',age=" + stu.getAge()
					+ " where id=" + stu.getId();
			int rs = stat.executeUpdate(sql);
			// 6处理结果
			if (rs > 0) {

				flag = true;
			}
			// 7关闭连接
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean delete(int id) {
		boolean flag = false; // 2 用反射的机制，加载驱动
		try {
			getStatement();

			// 5 执行sql语句
			String sql = "delete from student where id=" + id;
			int rs = stat.executeUpdate(sql);
			// 6处理结果
			if (rs > 0) {

				flag = true;
			}
			// 7关闭连接
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
