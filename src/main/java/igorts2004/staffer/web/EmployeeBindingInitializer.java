package igorts2004.staffer.web;

import igorts2004.staffer.domain.Employee;
import igorts2004.staffer.domain.EmployeeEditor;
import igorts2004.staffer.service.StafferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class EmployeeBindingInitializer implements WebBindingInitializer  {

	@Autowired
	private StafferService stafferService;

	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Employee.class, new EmployeeEditor());
	}

}
