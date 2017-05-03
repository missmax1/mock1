package model.bo;

import java.util.ArrayList;

import model.bean.LanguageScore;
import model.dao.LanguageScoreDAO;

public class LanguageScoreBO {
	LanguageScoreDAO languageScoreDAO = new LanguageScoreDAO();

	public ArrayList<LanguageScore> getListLanguageScore() {
		
		return languageScoreDAO.getListLanguageScore();
	}

	public ArrayList<LanguageScore> getListLanguageScore(String account, String fullName, String departmentId,
			String statusAccountId, String score) {
		// TODO Auto-generated method stub
		return languageScoreDAO.getListLanguageScore(account,fullName,departmentId,statusAccountId,score);
	}
	

}
