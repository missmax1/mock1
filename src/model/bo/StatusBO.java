package model.bo;

import java.util.ArrayList;

import model.bean.Status;
import model.dao.StatusDAO;

/**
 *StatusBO
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
public class StatusBO {
	
	StatusDAO statusDAO = new StatusDAO();

	/**
	 * get list Status
	 * @return 
	 */
	public ArrayList<Status> getListStatus() {
		return statusDAO.getListStatus();
	}

}
