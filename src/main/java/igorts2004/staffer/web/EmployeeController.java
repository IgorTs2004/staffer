package igorts2004.staffer.web;

import java.util.Date;
import java.util.List;

import igorts2004.staffer.domain.Employee;
import igorts2004.staffer.service.StafferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private StafferService stafferService;

	@RequestMapping(method = RequestMethod.GET)
	public String employeeList(Model model) {
		Date today = new Date();
		model.addAttribute("today", today);
		
		List<Employee> employees = stafferService.getEmployeeList();
		model.addAttribute("employees", employees);
		return "employee";
	}

}
