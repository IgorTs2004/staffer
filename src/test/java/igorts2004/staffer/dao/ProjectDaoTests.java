package igorts2004.staffer.dao;

import static org.junit.Assert.*;
import igorts2004.staffer.domain.Project;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectDaoTests {

	@Autowired
	private ProjectDao projectDao;
	
	final long TEST_ID = 1234567890;
	final String TEST_NAME = "Test project";
	
	@Test
	public void getProject_ExistingProject_ProjectIsReturned() {
		Project project = new Project(TEST_ID, TEST_NAME);
		ProjectDao dao = createDaoWithProject(project);
		
		Project result = dao.getProject(TEST_ID);
		
		assertEquals(project, result);
	}

	private ProjectDao createDaoWithProject(Project project) {
		projectDao.addProject(project);
		return projectDao;
	}

}
