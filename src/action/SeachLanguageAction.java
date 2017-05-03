package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LanguageScoreForm;
import model.bean.Department;
import model.bean.Khoa;
import model.bean.LanguageScore;
import model.bean.SinhVien;
import model.bean.Status;
import model.bo.DepartmentBO;
import model.bo.KhoaBO;
import model.bo.LanguageScoreBO;
import model.bo.SinhVienBO;
import model.bo.StatusBO;

public class SeachLanguageAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		LanguageScoreForm languageScoreForm = (LanguageScoreForm) form;
		
		//lay ds cac trang thai status
		ArrayList<Status> listStatus = null;
		StatusBO statusBO = new StatusBO();
		listStatus = statusBO.getListStatus();
		languageScoreForm.setListStatus(listStatus);
		
		// lay ds cac department
		DepartmentBO departmentBO = new DepartmentBO();
		ArrayList<Department> listDepartment = departmentBO.getListDepartment();
		languageScoreForm.setListDeparment(listDepartment);
		
		String statusAccountId=languageScoreForm.getStatusAccountId();
		String departmentId=languageScoreForm.getDepartmentId();
		String score = languageScoreForm.getScore();
		String account = languageScoreForm.getAccount();
		String fullName = languageScoreForm.getFullName();
		
		
		
		// lay ds languagescore
		ArrayList<LanguageScore> listLanguageScore = null;
		LanguageScoreBO languageScoreBO = new LanguageScoreBO();
		
		if(statusAccountId== null && account ==null && score == null && fullName == null && departmentId == null){
			listLanguageScore = languageScoreBO.getListLanguageScore();	
		}
		else{
			listLanguageScore = languageScoreBO.getListLanguageScore(account,fullName,departmentId,statusAccountId,score);
			
		}
		
		
		languageScoreForm.setListLanguageScore(listLanguageScore);
		
		
		
		return mapping.findForward("dsLanguageScore");
	}

	
	
}
