package igorts2004.staffer.web;

import java.util.List;
import java.util.Set;

import igorts2004.staffer.domain.Employee;
import igorts2004.staffer.domain.EmployeeEditor;
import igorts2004.staffer.domain.Project;
import igorts2004.staffer.service.StafferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("project")
public class ParticipantsController {

	@Autowired
	private StafferService stafferService;

	@ModelAttribute("allEmployees")
	public List<Employee> populateEmployees() {
		return stafferService.getEmployeeList();
	}

	/*
	 * @InitBinder protected void initBinder(WebDataBinder binder) {
	 * binder.registerCustomEditor(Employee.class, new
	 * EmployeeEditor(stafferService)); }
	 */

	/*@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Set.class, "participants",
				new CustomCollectionEditor(Set.class) {
					protected Object convertElement(Object element) {
						if (element instanceof Employee) {
							System.out
									.println("Converting from Employee to Employee: "
											+ element);
							return element;
						}
						if (element instanceof Long) {
							long id = (Long)element;
							Employee employee = stafferService.getEmployee(id);
							System.out.println("Looking up staff for id "
									+ element + ": " + employee);
							return employee;
						}
						System.out.println("Don't know what to do with: "
								+ element);
						return null;
					}
				});
	}*/

	@RequestMapping(value = "/project-edit", method = RequestMethod.GET)
	public String setupForm(@RequestParam("projectId") Long projectId,
			Model model) {
		Project project = stafferService.getProject(projectId);
		model.addAttribute("project", project);
		return "project-edit";
	}

	@RequestMapping(value = "/project-edit/update", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("project") Project project,
			BindingResult result) {
		stafferService.updateProject(project);
		return "redirect:/project";
	}

}
