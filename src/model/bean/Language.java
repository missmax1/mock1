package model.bean;

/**
 * Language
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
public class Language {

	private String languageTypeId;
	private String languageName;

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getLanguageTypeId() {
		return languageTypeId;
	}

	public void setLanguageTypeId(String languageTypeId) {
		this.languageTypeId = languageTypeId;
	}

}
