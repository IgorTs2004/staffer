package igorts2004.staffer.domain;

import java.beans.PropertyEditorSupport;

import igorts2004.staffer.service.StafferService;

public class EmployeeEditor extends PropertyEditorSupport {

	private StafferService stafferService;

	public EmployeeEditor(StafferService stafferService) {
		this.stafferService = stafferService;
	}

	public void setAsText(String text) throws IllegalArgumentException {
		long id = Long.parseLong(text);
		Employee employee = stafferService.getEmployee(id);
		setValue(employee);
	}
}