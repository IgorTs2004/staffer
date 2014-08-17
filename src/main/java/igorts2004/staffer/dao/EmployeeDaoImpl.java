package igorts2004.staffer.dao;

import igorts2004.staffer.domain.Employee;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	private Connection connection;

	@PostConstruct
	public void createDbConnection() throws Exception {
		final String driver = "com.mysql.jdbc.Driver";
		final String url = "jdbc:mysql://localhost:3306/staffer";
		final String user = "admin";
		final String password = "admin";

		Class.forName(driver);
		connection = DriverManager.getConnection(url, user, password);
	}

	@PreDestroy
	public void closeDbConnection() throws Exception {
		connection.close();
	}

	@Override
	public List<Employee> getEmployeeList() {
		final String sql = "SELECT id, name FROM Employee";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			List<Employee> result = new LinkedList<>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				result.add(new Employee(id, name));
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
