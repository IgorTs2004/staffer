package igorts2004.staffer.dao;

import igorts2004.staffer.domain.Employee;

import java.util.List;

public interface EmployeeDao {

	public List<Employee> getEmployeeList();
	
	public Long addEmployee(String name);

}
