package igorts2004.staffer.web;

import igorts2004.staffer.domain.Employee;
import igorts2004.staffer.service.StafferService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		this.process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		this.process(request, response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		StafferService employeeService = context.getBean("stafferService",
				StafferService.class);
		List<Employee> employeeList = employeeService.getEmployeeList();

		response.setStatus(200);
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<style type=\"text/css\">");
		writer.println("table {");
		writer.println("border-collapse: collapse;");
		writer.println("}");
		writer.println("td, th {");
		writer.println("border: 3px solid #800;");
		writer.println("padding: 4px;");
		writer.println("}");
		writer.println("</style>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2>Employee List</h2>");
		writer.println("<table>");
		writer.println("<tr><th>id</th><th>name</th></tr>");
		for (Employee employee : employeeList) {
			writer.println("<tr><td>" + employee.getId() + "</td><td>"
					+ employee.getName() + "</td></tr>");
		}
		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html>");
		// writer.write(responseTemplate);
	}
}
