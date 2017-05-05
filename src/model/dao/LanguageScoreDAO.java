package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.LanguageScore;

/**
 * LanguageScoreDAO
 *
 * version 1.0
 *
 * Date 03/04/2017
 *
 * Copyright
 *
 * Modification Logs:
 *
 * DATE AUTHOR DESCRIPTION
 * -----------------------------------------------------------------------
 * 03/04-2017 LinhTN8 Create
 *
 */
public class LanguageScoreDAO {

	String url = "jdbc:sqlserver://localhost:1433;instance=MSSQLSERVER;databaseName=Mock1";
	String userName = "sa";
	String password = "12345678";
	Connection connection;

	/**
	 * kết nối csdl
	 */
	void connect() {
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

	/**
	 * get all data for languagescore join account join Department join status
	 * 
	 * @return list
	 */
	public ArrayList<LanguageScore> getListLanguageScore() {

		connect();
		String sql = "select LanguageScore.LanguageScoreId,LanguageScore.EmployeeId,AccountName,FullName,DepartmentName,LanguageName,Score,Date,Note "
				+ "from LanguageScore join Language on Language.LanguageTypeId= LanguageScore.LanguageTypeId "
				+ "join Account on Account.EmployeeId = LanguageScore.EmployeeId "
				+ "join Department on Department.DepartmentId = Account.DepartmentId "
				+ "join Status on Status.StatusAccountId = Account.StatusAccountId " + "order by Score desc ";

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// tạo list languagescore
		ArrayList<LanguageScore> list = new ArrayList<LanguageScore>();
		LanguageScore languageScore;
		try {
			while (rs.next()) {
				languageScore = new LanguageScore();
				languageScore.setLanguageScoreId(rs.getString("LanguageScoreId"));
				languageScore.setEmployeeId(rs.getString("EmployeeId"));

				// convert date
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateInString = rs.getString("Date");
				try {
					Date date = formatter.parse(dateInString);
					languageScore.setDate(df.format(date));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				languageScore.setScore(rs.getString("Score"));
				languageScore.setNote(rs.getString("Note"));
				languageScore.setScore(rs.getString("Score"));
				languageScore.setLanguageName(rs.getString("LanguageName"));
				languageScore.setAccountName(rs.getString("AccountName"));
				languageScore.setFullName(rs.getString("FullName"));
				languageScore.setDepartmentName(rs.getString("DepartmentName"));
				list.add(languageScore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * get data languagescore with param
	 * 
	 * @param account
	 * @param fullName
	 * @param departmentId
	 * @param statusAccountId
	 * @param score
	 * @return list
	 */
	public ArrayList<LanguageScore> getListLanguageScore(String account, String fullName, String departmentId,
			String statusAccountId, String score) {
		String sql;
		connect();

		// kiểm tra các giá trị nhập vào rỗng thì hiển thị tất cả
		if (account == "" && fullName == "" && score == "" && departmentId == "" && statusAccountId == "") {
			sql = "select LanguageScore.LanguageScoreId,LanguageScore.EmployeeId,AccountName,FullName,DepartmentName,LanguageName,Score,Date,Note "
					+ "from LanguageScore join Language on Language.LanguageTypeId= LanguageScore.LanguageTypeId "
					+ "join Account on Account.EmployeeId = LanguageScore.EmployeeId "
					+ "join Department on Department.DepartmentId = Account.DepartmentId "
					+ "join Status on Status.StatusAccountId = Account.StatusAccountId " + "order by Score desc ";
		} else {

			// nếu một trong các trường khác rỗng thì sẽ hiển thị value tương
			// ứng với trường đó
			if (account == "")
				account = null;
			if (fullName == "")
				fullName = null;
			if (score == "")
				score = null;
			if (departmentId == "")
				departmentId = null;
			if (statusAccountId == "")
				statusAccountId = null;

			sql = "select LanguageScore.LanguageScoreId,LanguageScore.EmployeeId,AccountName,FullName,DepartmentName,LanguageName,Score,Date,Note "
					+ "from LanguageScore join Language on Language.LanguageTypeId= LanguageScore.LanguageTypeId "
					+ "join Account on Account.EmployeeId = LanguageScore.EmployeeId "
					+ "join Department on Department.DepartmentId = Account.DepartmentId "
					+ "join Status on Status.StatusAccountId = Account.StatusAccountId " + "where AccountName like N'%"
					+ account + "%' or  FullName like N'%" + fullName + "%' or Score like N'%" + score + "%' or "
					+ "Department.DepartmentId like '%" + departmentId + "%' or Status.StatusAccountId like '%"
					+ statusAccountId + "%' ";
		}

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<LanguageScore> list = new ArrayList<LanguageScore>();
		LanguageScore languageScore;
		try {
			while (rs.next()) {
				languageScore = new LanguageScore();
				languageScore.setLanguageScoreId(rs.getString("LanguageScoreId"));
				languageScore.setEmployeeId(rs.getString("EmployeeId"));
				
				//convert date
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateInString = rs.getString("Date");
				try {
					Date date = formatter.parse(dateInString);
					System.out.println(date);
					System.out.println(df.format(date));
					languageScore.setDate(df.format(date));

				} catch (ParseException e) {
					e.printStackTrace();
				}
				languageScore.setScore(rs.getString("Score"));
				languageScore.setNote(rs.getString("Note"));
				languageScore.setScore(rs.getString("Score"));
				languageScore.setLanguageName(rs.getString("LanguageName"));
				languageScore.setAccountName(rs.getString("AccountName"));
				languageScore.setFullName(rs.getString("FullName"));
				languageScore.setDepartmentName(rs.getString("DepartmentName"));
				list.add(languageScore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	/**
	 * get list languagescore by param 
	 * @param score
	 * @return
	 */
	public ArrayList<LanguageScore> getListLanguageScore(String score) {
		connect();
		String sql = "select LanguageScore.LanguageScoreId,LanguageScore.EmployeeId,AccountName,FullName,DepartmentName,LanguageName,Score,Date,Note "
				+ "from LanguageScore join Language on Language.LanguageTypeId= LanguageScore.LanguageTypeId "
				+ "join Account on Account.EmployeeId = LanguageScore.EmployeeId "
				+ "join Department on Department.DepartmentId = Account.DepartmentId "
				+ "join Status on Status.StatusAccountId = Account.StatusAccountId " + "where Score like '%" + score
				+ "%' ";

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// tạo list languagescore
		ArrayList<LanguageScore> list = new ArrayList<LanguageScore>();
		LanguageScore languageScore;
		try {
			while (rs.next()) {
				languageScore = new LanguageScore();
				languageScore.setLanguageScoreId(rs.getString("LanguageScoreId"));
				languageScore.setEmployeeId(rs.getString("EmployeeId"));
				// hàm convert date
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateInString = rs.getString("Date");
				try {
					Date date = formatter.parse(dateInString);
					languageScore.setDate(df.format(date));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				languageScore.setScore(rs.getString("Score"));
				languageScore.setNote(rs.getString("Note"));
				languageScore.setScore(rs.getString("Score"));
				languageScore.setLanguageName(rs.getString("LanguageName"));
				languageScore.setAccountName(rs.getString("AccountName"));
				languageScore.setFullName(rs.getString("FullName"));
				languageScore.setDepartmentName(rs.getString("DepartmentName"));
				list.add(languageScore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
