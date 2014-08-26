package igorts2004.staffer.web;

import java.util.List;

import igorts2004.staffer.domain.Employee;
import igorts2004.staffer.domain.Project;
import igorts2004.staffer.service.StafferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WSController {

	@Autowired
	private StafferService stafferService;

	@RequestMapping(value = "/ws/employee", headers = "Accept=application/json")
	public List<Employee> getEmployees() {
		return stafferService.getEmployeeList();
	}
	
	@RequestMapping(value = "/ws/project", headers = "Accept=application/json")
	public List<Project> getProjects() {
		return stafferService.getProjectList();
	}	

}
