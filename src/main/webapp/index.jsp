<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false"%>

<html>
<body>
	<h2>Employee Management System</h2>

	<security:authorize ifAllGranted="ROLE_USER">
	Welcome <b><security:authentication property="name" /></b>
	<br>
	<a href="employee">Employee List</a>
	<br>
	<a href="project">Project List</a>
	<br>
	<br>
	<a href="employee-from-ws">Employee List from Web Service</a>
	<br>
	<a href="project-from-ws">Project List from Web Service</a>
	<br>
	<br>
	<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
	</security:authorize>
	
	<security:authorize ifNotGranted="ROLE_USER">
	<a href="<c:url value="/spring_security_login" />">Login</a>
	</security:authorize>
</body>
</html>
