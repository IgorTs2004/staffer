package igorts2004.staffer.service;

import igorts2004.staffer.dao.EmployeeDao;
import igorts2004.staffer.entity.Employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public List<Employee> getEmployeeList() {
		return employeeDao.getEmployeeList();
	}
	
}
