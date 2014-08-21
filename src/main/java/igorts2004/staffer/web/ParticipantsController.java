package igorts2004.staffer.web;

import java.util.List;

import igorts2004.staffer.domain.Project;
import igorts2004.staffer.service.StafferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParticipantsController {

	@Autowired
	private StafferService stafferService;

	@RequestMapping(value = "/participants", method = RequestMethod.GET)
	public String setupForm(@RequestParam("projectId") Long projectId,
			Model model) {
		Project project = stafferService.getProject(projectId);
		model.addAttribute("project", project);
		return "participants";
	}

	/*
	 * @RequestMapping(value = "/participants/add", method = RequestMethod.POST)
	 * public String addContact(@ModelAttribute("project") Project project,
	 * BindingResult result) { stafferService.addProject(project);
	 * 
	 * return "redirect:/project"; }
	 */

	@RequestMapping(value = "/participants/remove", method = RequestMethod.GET)
	public String removeParticipant(@RequestParam("projectId") Long projectId,
			@RequestParam("employeeId") Long employeeId) {
		stafferService.removeParticipant(projectId, employeeId);
		return "redirect:/participants?projectId="+projectId;
	}

}
