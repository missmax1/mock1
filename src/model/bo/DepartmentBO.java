package model.bo;

import java.util.ArrayList;

import model.bean.Department;
import model.dao.DepartmentDAO;

/**
 *DepartmentBO
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
public class DepartmentBO {
	
	DepartmentDAO departmentDAO = new DepartmentDAO();
	
	/**
	 * get list department
	 * @return
	 */
	public ArrayList<Department> getListDepartment() {
		return departmentDAO.getListDepartment();
	}
	
	
}
