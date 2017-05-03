package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Department;
import model.bean.Status;

public class DepartmentDAO {
	
	String url = "jdbc:sqlserver://localhost:1433;instance=MSSQLSERVER;databaseName=Mock1";
	String userName = "sa";
	String password = "12345678";
	Connection connection;
	
	void connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
	}
	
	public ArrayList<Department> getListDepartment() {
		connect();
		String sql=	"SELECT * FROM Department";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Department> list = new ArrayList<Department>();
		Department department;
		try {
			while(rs.next()){
				department = new Department();
				department.setDepartmentId(rs.getString("DepartmentId"));
				department.setDepartmentName(rs.getString("DepartmentName"));
				list.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
