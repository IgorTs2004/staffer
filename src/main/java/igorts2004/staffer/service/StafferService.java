package igorts2004.staffer.service;

import igorts2004.staffer.dao.EmployeeDao;
import igorts2004.staffer.domain.Employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stafferService")
public class StafferService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getEmployeeList() {
		return employeeDao.getEmployeeList();
	}
	
	
}
