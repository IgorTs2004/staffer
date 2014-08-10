package igorts2004.staffer;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Override
	public List<Employee> getEmployeeList() {
		return Arrays.asList(new Employee(1, "Test"));
	}

}
