package model.bo;

import java.util.ArrayList;

import model.bean.LanguageScore;
import model.dao.LanguageScoreDAO;

/**
 *LanguageScoreBO
 *
 *version 1.0
 *
 *Date 03/04/2017
 *
 *Copyright
 *
 *Modification Logs:
 *
 *DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 *03/04-2017         	LinhTN8            Create 
 *
 */
public class LanguageScoreBO {
	LanguageScoreDAO languageScoreDAO = new LanguageScoreDAO();
	
	/**
	 * get list all languagescore
	 * @return
	 */
	public ArrayList<LanguageScore> getListLanguageScore() {

		return languageScoreDAO.getListLanguageScore();
	}
	
	/**
	 * get list languagescore
	 * @param account
	 * @param fullName
	 * @param departmentId
	 * @param statusAccountId
	 * @param score
	 * @return
	 */
	public ArrayList<LanguageScore> getListLanguageScore(String account, String fullName, String departmentId,
			String statusAccountId, String score) {

		return languageScoreDAO.getListLanguageScore(account, fullName, departmentId, statusAccountId, score);
	}
	
	/**
	 * get list score
	 * @param score
	 * @return
	 */
	public ArrayList<LanguageScore> getListLanguageScore(String score) {

		return languageScoreDAO.getListLanguageScore(score);
	}

}
