package igorts2004.staffer.dao;

import igorts2004.staffer.domain.Project;

import java.util.List;

public interface ProjectDao {

	public Project getProject(long id);
	
	public List<Project> getProjectList();

	public long addProject(Project project);

	public void deleteProject(long id);

}
