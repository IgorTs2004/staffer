<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Employee list</title>
</head>

<body>
	<h2>This is employee.jsp</h2>
	Today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />.

	<form method="post">
		Employee Name <input type="text" name="employeeName" value="${employeeName}" />
		<input type="submit" value="Add" />
	</form>

	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td><a href="employee/delete?id=${employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>