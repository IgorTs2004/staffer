package igorts2004.staffer.domain;

import java.beans.PropertyEditorSupport;

import igorts2004.staffer.service.StafferService;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeEditor extends PropertyEditorSupport {
	
	@Autowired
	private StafferService stafferService;

	public void setAsText(String text) throws IllegalArgumentException {
		int id = Integer.parseInt(text);
		Employee employee = stafferService.getEmployee(id);
		setValue(employee);
	}
}