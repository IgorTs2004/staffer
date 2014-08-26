<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Employee List from Web Service</title>
</head>

<body>
	<h2>Employee List from Web Service</h2>

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
			</tr>
		</c:forEach>
	</table>

</body>
</html>