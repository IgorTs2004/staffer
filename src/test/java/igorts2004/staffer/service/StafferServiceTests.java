package igorts2004.staffer.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import igorts2004.staffer.dao.EmployeeDao;
import igorts2004.staffer.dao.ProjectDao;
import igorts2004.staffer.domain.Employee;
import igorts2004.staffer.domain.Project;

import org.junit.Test;

public class StafferServiceTests {
	
	final long TEST_ID = 12345;
		
	@Test
	public void getEmployee_WhenInvoked_DaoIsCalled() {
		EmployeeDao mockedEmployeeDao = mock(EmployeeDao.class);
		StafferService service = createServiceWith(mockedEmployeeDao);
		
		service.getEmployee(TEST_ID);
		
		verify(mockedEmployeeDao).getEmployee(TEST_ID);
	}

	@Test
	public void getEmployeeList_WhenInvoked_DaoIsCalled() {
		EmployeeDao mockedEmployeeDao = mock(EmployeeDao.class);
		StafferService service = createServiceWith(mockedEmployeeDao);
		
		service.getEmployeeList();
		
		verify(mockedEmployeeDao).getEmployeeList();
	}	
	
	@Test
	public void addEmployee_WhenInvoked_DaoIsCalled() {
		EmployeeDao mockedEmployeeDao = mock(EmployeeDao.class);
		StafferService service = createServiceWith(mockedEmployeeDao);
		Employee employee = new Employee();
		
		service.addEmployee(employee);
		
		verify(mockedEmployeeDao).addEmployee(employee);
	}	
	
	@Test
	public void deleteEmployee_WhenInvoked_DaoIsCalled() {
		EmployeeDao mockedEmployeeDao = mock(EmployeeDao.class);
		StafferService service = createServiceWith(mockedEmployeeDao);
		
		service.deleteEmployee(TEST_ID);
		
		verify(mockedEmployeeDao).deleteEmployee(TEST_ID);
	}	

	@Test
	public void getProject_WhenInvoked_DaoIsCalled() {
		ProjectDao mockedProjectDao = mock(ProjectDao.class);
		StafferService service = createServiceWith(mockedProjectDao);
		
		service.getProject(TEST_ID);
		
		verify(mockedProjectDao).getProject(TEST_ID);
	}	
	
	@Test
	public void getProjectList_WhenInvoked_DaoIsCalled() {
		ProjectDao mockedProjectDao = mock(ProjectDao.class);
		StafferService service = createServiceWith(mockedProjectDao);
		
		service.getProjectList();
		
		verify(mockedProjectDao).getProjectList();
	}	

	@Test
	public void addProject_WhenInvoked_DaoIsCalled() {
		ProjectDao mockedProjectDao = mock(ProjectDao.class);
		StafferService service = createServiceWith(mockedProjectDao);
		Project project = new Project();
		
		service.addProject(project);
		
		verify(mockedProjectDao).addProject(project);
	}	
	
	@Test
	public void deleteProject_WhenInvoked_DaoIsCalled() {
		ProjectDao mockedProjectDao = mock(ProjectDao.class);
		StafferService service = createServiceWith(mockedProjectDao);
		
		service.deleteProject(TEST_ID);
		
		verify(mockedProjectDao).deleteProject(TEST_ID);
	}	

	@Test
	public void updateProject_WhenInvoked_DaoIsCalled() {
		ProjectDao mockedProjectDao = mock(ProjectDao.class);
		StafferService service = createServiceWith(mockedProjectDao);
		Project project = new Project();
		
		service.updateProject(project);
		
		verify(mockedProjectDao).updateProject(project);
	}	
	
	// --- Helper methods ---
	
	private StafferService createServiceWith(EmployeeDao employeeDao) {
		return new StafferService(employeeDao, null);
	}
	
	private StafferService createServiceWith(ProjectDao projectDao) {
		return new StafferService(null, projectDao);
	}
		
}
