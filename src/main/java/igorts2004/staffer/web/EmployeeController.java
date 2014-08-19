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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@SessionAttributes("employee")
public class EmployeeController {

	@Autowired
	private StafferService stafferService;

	@ModelAttribute("allEmployees")
    public List<Employee> populateEmployees() {
        return stafferService.getEmployeeList();
    }
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String setupForm(Model model) {
		Date today = new Date();
		model.addAttribute("today", today);

		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		List<Employee> employees = stafferService.getEmployeeList();
		model.addAttribute("employees", employees);
		return "employee";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("employee") Employee employee,
			BindingResult result) {
		stafferService.addEmployee(employee);

		return "redirect:/employee";
	}

	@RequestMapping(value = "/employee/delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam("id") Long id) {
		stafferService.deleteEmployee(id);
		return "redirect:/employee";
	}

}
