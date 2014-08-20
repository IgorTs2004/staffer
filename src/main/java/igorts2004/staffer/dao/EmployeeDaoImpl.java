package igorts2004.staffer.dao;

import igorts2004.staffer.domain.Employee;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;	
	
    @Override
    public Employee getEmployee(long id) {
    	return (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeList() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();	
	}
	
	@Override
	public long addEmployee(Employee employee) {
		return (Long) sessionFactory.getCurrentSession().save(employee);
	}
	
	@Override
	public void deleteEmployee(long id) {
		// TODO Query can be used to delete by id
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
        if (null != employee) {
            sessionFactory.getCurrentSession().delete(employee);
        }
	}
    	
}
