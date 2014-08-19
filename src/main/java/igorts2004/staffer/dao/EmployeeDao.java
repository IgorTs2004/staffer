package igorts2004.staffer.dao;

import igorts2004.staffer.domain.Employee;

import java.util.List;

public interface EmployeeDao {

	public Employee getEmployee(long id);
	
	public List<Employee> getEmployeeList();

	public long addEmployee(Employee employee);	
	
	public void deleteEmployee(long id);

}
