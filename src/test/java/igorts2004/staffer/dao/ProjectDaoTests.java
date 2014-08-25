package igorts2004.staffer.dao;

import static org.junit.Assert.*;

import java.util.List;

import igorts2004.staffer.domain.Project;

import static org.hamcrest.Matchers.*;

import org.hibernate.ObjectNotFoundException;
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
	
	@Test
	public void getProject_ExistingProject_ProjectIsReturned() {
		Project project = new Project("Test project");
		long projectId = createProject(project);
		
		Project result = projectDao.getProject(projectId);
		
		assertEquals(project, result);
	}
	
	@Test
	public void getProject_NonExistentProject_NullIsReturned() {
		final long NON_EXISTENT_ID = 1234567890;
		
		Project result = projectDao.getProject(NON_EXISTENT_ID);
		
		assertNull(result);
	}

	@Test
	public void getProjectList_ProjectsExist_ProjectsAreReturned() {
		Project project1 = new Project("Test project 1");
		Project project2 = new Project("Test project 2");
		createProject(project1);
		createProject(project2);
		
		List<Project> result = projectDao.getProjectList();
		
		assertThat(result, hasItems(project1, project2));
	}
	
	@Test
	public void addProject_NewProject_ProjectIsAdded() {
		Project project = new Project("Test project");
		
		long projectId = projectDao.addProject(project);
		
		Project result = projectDao.getProject(projectId);
		assertEquals(project,  result);
	}
	
	@Test
	public void deleteProject_ExistingProject_ProjectIsDeleted() {
		Project project = new Project("Test project");
		long projectId = createProject(project);
		
		projectDao.deleteProject(projectId);
		
		Project result = projectDao.getProject(projectId);		
		assertNull(result);
	}
	
	@Test(expected = ObjectNotFoundException.class)
	public void deleteProject_NonExistentProject_ExceptionIsThrown() {
		final long NON_EXISTENT_ID = 1234567890;
		
		projectDao.deleteProject(NON_EXISTENT_ID);
	}
	
	@Test
	public void updateProject_NewName_NameIsChanged() {
		final String NEW_NAME = "New name";
		Project project = new Project("Test project");
		long projectId = createProject(project);
		
		project.setName(NEW_NAME);
		projectDao.updateProject(project);
		
		Project result = projectDao.getProject(projectId);		
		assertEquals(NEW_NAME, result.getName());
	}
	
	// TODO For some reason Hibernate doesn't complain when we try to update non-existent entity
	/*
	@Test(expected = ObjectNotFoundException.class)
	public void updateProject_NonExistentProject_ExceptionIsThrown() {
		Project nonExistentProject = new Project("Non existent");
		
		nonExistentProject.setName("New name");
		projectDao.updateProject(nonExistentProject);
	}
	*/
	
	// --- Helper methods ---
		
	@Autowired
    private SessionFactory sessionFactory;
	
	private long createProject(Project project) {
		return (Long) sessionFactory.getCurrentSession().save(project);
	}

}
