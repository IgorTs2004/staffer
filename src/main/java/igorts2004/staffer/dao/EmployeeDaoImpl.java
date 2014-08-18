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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeList() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();	
	}
	
	@Override
	public long addEmployee(String name) {
		Employee employee = new Employee(0, name);
		return (Long) sessionFactory.getCurrentSession().save(employee);
	}
	
	@Override
	public void deleteEmployee(long id) {
		Employee contact = (Employee) sessionFactory.getCurrentSession().load(Employee.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
	}
    	
}
