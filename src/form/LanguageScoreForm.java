package form;



import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Department;
import model.bean.LanguageScore;
import model.bean.Status;

public class LanguageScoreForm extends ActionForm{

	private String employeeId;
	private String statusAccountId;
	private String departmentId;
	private String languageTypeId;
	private String languageScoreId;
	private ArrayList<LanguageScore> listLanguageScore;
	private ArrayList<Status> listStatus;
	private ArrayList<Department> listDeparment;
	
	private String score;
	private String account;
	private String fullName;

	
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getStatusAccountId() {
		return statusAccountId;
	}
	public void setStatusAccountId(String statusAccountId) {
		this.statusAccountId = statusAccountId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getLanguageTypeId() {
		return languageTypeId;
	}
	public void setLanguageTypeId(String languageTypeId) {
		this.languageTypeId = languageTypeId;
	}
	public String getLanguageScoreId() {
		return languageScoreId;
	}
	public void setLanguageScoreId(String languageScoreId) {
		this.languageScoreId = languageScoreId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public ArrayList<LanguageScore> getListLanguageScore() {
		return listLanguageScore;
	}
	public void setListLanguageScore(ArrayList<LanguageScore> listLanguageScore) {
		this.listLanguageScore = listLanguageScore;
	}
	public ArrayList<Status> getListStatus() {
		return listStatus;
	}
	public void setListStatus(ArrayList<Status> listStatus) {
		this.listStatus = listStatus;
	}
	public ArrayList<Department> getListDeparment() {
		return listDeparment;
	}
	public void setListDeparment(ArrayList<Department> listDeparment) {
		this.listDeparment = listDeparment;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	



	
}
