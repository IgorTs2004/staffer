package igorts2004.staffer.web;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class FromWSController {

	@RequestMapping(value = "/employee-from-ws", method = RequestMethod.GET)
	public String employeeListFromWS(Model model) {
		final String url="http://localhost:8080/staffer/ws/employee";
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> employees=restTemplate.getForObject(url, List.class);
		model.addAttribute("employees", employees);
		return "employee-from-ws";
	}
		
}
