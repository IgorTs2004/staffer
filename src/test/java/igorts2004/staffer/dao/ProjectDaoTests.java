package igorts2004.staffer.dao;

import static org.junit.Assert.*;
import igorts2004.staffer.domain.Project;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration; 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/staffer-persistence.xml")
@Transactional
public class ProjectDaoTests {
	
	@Autowired
	private ProjectDao projectDao;
	
	final String TEST_NAME = "Test project";
	
	@Test
	public void getProject_ExistingProject_ProjectIsReturned() {
		Project project = new Project(TEST_NAME);
		long projectId = createProject(project);
		
		Project result = projectDao.getProject(projectId);
		
		assertEquals(project, result);
	}

	// --- Helper methods ---
		
	@Autowired
    private SessionFactory sessionFactory;
	
	private long createProject(Project project) {
		return (Long) sessionFactory.getCurrentSession().save(project);
	}

}
