package model.bo;

import java.util.ArrayList;

import model.bean.Department;
import model.bean.Status;
import model.dao.DepartmentDAO;

public class DepartmentBO {
	
	DepartmentDAO departmentDAO = new DepartmentDAO();

	public ArrayList<Department> getListDepartment() {
		return departmentDAO.getListDepartment();
	}
	
	
}
