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
import model.bean.LanguageScore;
import model.bean.Status;
import model.bo.DepartmentBO;
import model.bo.LanguageScoreBO;
import model.bo.StatusBO;

/**
 * SeachLanguageAction
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
 * 04/04-2017 LinhTN8 Create
 *
 */
public class SeachLanguageAction extends Action {

	/**
	 * execute languagescoreform 
	 * @param mapping 
	 * @param form
	 * @param request
	 * @param response
	 * @return mapping
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// set mã UTF-8
		request.setCharacterEncoding("UTF-8");
		LanguageScoreForm languageScoreForm = (LanguageScoreForm) form;

		// lay ds cac trang thai status
		ArrayList<Status> listStatus = null;
		StatusBO statusBO = new StatusBO();
		listStatus = statusBO.getListStatus();
		languageScoreForm.setListStatus(listStatus);

		// lay ds cac department
		DepartmentBO departmentBO = new DepartmentBO();
		ArrayList<Department> listDepartment = departmentBO.getListDepartment();
		languageScoreForm.setListDeparment(listDepartment);

		// tạo các biến để lấy dl từ form
		String selectSeach = languageScoreForm.getSelectSeach();
		String statusAccountId = languageScoreForm.getStatusAccountId();
		String departmentId = languageScoreForm.getDepartmentId();
		String score = languageScoreForm.getScore();
		String account = languageScoreForm.getAccount();
		String fullName = languageScoreForm.getFullName();

		// lay ds languagescore
		ArrayList<LanguageScore> listLanguageScore = null;
		LanguageScoreBO languageScoreBO = new LanguageScoreBO();

		// kiểm tra select seach
		if ("1".equals(selectSeach)) {

			// get list languge score with param score
			listLanguageScore = languageScoreBO.getListLanguageScore(score);

		} else {

			// kiểm tra tất cả các giá trị nhập vào có rỗng k
			if (statusAccountId == null && account == null && score == null && fullName == null
					&& departmentId == null) {
				listLanguageScore = languageScoreBO.getListLanguageScore();
				
			} else {
				listLanguageScore = languageScoreBO.getListLanguageScore(account, fullName, departmentId,
						statusAccountId, score);

			}
		}
		languageScoreForm.setListLanguageScore(listLanguageScore);

		return mapping.findForward("dsLanguageScore");
	}

}
