<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Employee List</title>
</head>

<body>
	<a href="<c:url value="/j_spring_security_logout" />">Logout</a>

	<h2>Employee List</h2>

	<form:form method="post" action="employee/add" modelAttribute="employee">
		<table>
			<tr>
				<td>Employee Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Superior</td>
				<td><form:select path="superior" items="${allEmployees}"
						itemValue="id" itemLabel="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>

	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>superior</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.superior.name}</td>
				<td><a href="employee/delete?id=${employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>