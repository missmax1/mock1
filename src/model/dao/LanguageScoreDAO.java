package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.LanguageScore;
import model.bean.SinhVien;

public class LanguageScoreDAO {

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
	
	public ArrayList<LanguageScore> getListLanguageScore() {
		
		connect();
		String sql=	"select LanguageScore.LanguageScoreId,LanguageScore.EmployeeId,AccountName,FullName,DepartmentName,LanguageName,Score,Date,Note "+
					"from LanguageScore join Language on Language.LanguageTypeId= LanguageScore.LanguageTypeId "+
					"join Account on Account.EmployeeId = LanguageScore.EmployeeId "+
					"join Department on Department.DepartmentId = Account.DepartmentId "+
					"join Status on Status.StatusAccountId = Account.StatusAccountId "+
					"order by Score desc ";
					
					
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
			while(rs.next()){
				languageScore = new LanguageScore();
				languageScore.setLanguageScoreId(rs.getString("LanguageScoreId"));
				languageScore.setEmployeeId(rs.getString("EmployeeId"));
				languageScore.setDate(rs.getString("Date"));
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

	public ArrayList<LanguageScore> getListLanguageScore(String account, String fullName, String departmentId,
			String statusAccountId, String score) {
		
		connect();
		String sql=	"select LanguageScore.LanguageScoreId,LanguageScore.EmployeeId,AccountName,FullName,DepartmentName,LanguageName,Score,Date,Note "+
					"from LanguageScore join Language on Language.LanguageTypeId= LanguageScore.LanguageTypeId "+
					"join Account on Account.EmployeeId = LanguageScore.EmployeeId "+
					"join Department on Department.DepartmentId = Account.DepartmentId "+
					"join Status on Status.StatusAccountId = Account.StatusAccountId "+
					"where AccountName like N'%"+account+"%' and FullName like N'%"+fullName+"%' and Score like N'%"+score+"%' "+
					"and  Account.DepartmentId like N'%"+departmentId+"%' and Account.StatusAccountId like N'%"+statusAccountId+"%' ";
					
		System.out.println(sql);			
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
			while(rs.next()){
				languageScore = new LanguageScore();
				languageScore.setLanguageScoreId(rs.getString("LanguageScoreId"));
				languageScore.setEmployeeId(rs.getString("EmployeeId"));
				languageScore.setDate(rs.getString("Date"));
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
