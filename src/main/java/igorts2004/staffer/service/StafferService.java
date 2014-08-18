package igorts2004.staffer.service;

import igorts2004.staffer.dao.EmployeeDao;
import igorts2004.staffer.domain.Employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("stafferService")
public class StafferService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	public List<Employee> getEmployeeList() {
		return employeeDao.getEmployeeList();
	}
	
	@Transactional
	public Long addEmployee(String name) {
		return employeeDao.addEmployee(name);
	}
	
	@Transactional
	public void deleteEmployee(Long id) {
		employeeDao.deleteEmployee(id);
	}
	
}
