package model.bo;

import java.util.ArrayList;

import model.bean.Status;
import model.dao.StatusDAO;

public class StatusBO {

	
	StatusDAO  statusDAO = new StatusDAO();
	public ArrayList<Status> getListStatus() {
		return statusDAO.getListStatus();
	}

}
