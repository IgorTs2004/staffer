<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Manage Participants</title>
</head>

<body>
	<h2>Manage Participants</h2>


	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>superior</th>
		</tr>
		<c:forEach items="${project.participants}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.superior.name}</td>
				<td><a href="participants/remove?projectId=${project.id}&employeeId=${employee.id}">Remove</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>