package igorts2004.staffer.dao;

import igorts2004.staffer.domain.Project;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;	

    @Override
    public Project getProject(long id) {
    	return (Project) sessionFactory.getCurrentSession().get(Project.class, id);
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectList() {
		return sessionFactory.getCurrentSession().createQuery("from Project").list();	
	}
	
	@Override
	public long addProject(Project project) {
		return (Long) sessionFactory.getCurrentSession().save(project);
	}
	
	@Override
	public void deleteProject(long id) {
		// TODO Query can be used to delete by id
		Project project = (Project) sessionFactory.getCurrentSession().load(Project.class, id);
        if (null != project) {
            sessionFactory.getCurrentSession().delete(project);
        }
	}
	
	@Override
	public void updateProject(Project project) {
		sessionFactory.getCurrentSession().update(project);
	}
	
}
