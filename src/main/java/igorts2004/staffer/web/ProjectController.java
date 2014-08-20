package igorts2004.staffer.web;

import igorts2004.staffer.domain.Project;
import igorts2004.staffer.service.StafferService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("project")
public class ProjectController {

	@Autowired
	private StafferService stafferService;

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String setupForm(Model model) {
		Project project = new Project();
		model.addAttribute("project", project);
		
		List<Project> projects = stafferService.getProjectList();
		model.addAttribute("projects", projects);
		return "project";
	}

	@RequestMapping(value = "/project/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("project") Project project,
			BindingResult result) {
		stafferService.addProject(project);

		return "redirect:/project";
	}

	@RequestMapping(value = "/project/delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam("id") Long id) {
		stafferService.deleteProject(id);
		return "redirect:/project";
	}

}
