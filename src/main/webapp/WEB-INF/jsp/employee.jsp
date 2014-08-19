<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Employee list</title>
</head>

<body>
	<h2>This is employee.jsp</h2>
	Today is
	<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />
	.

	<form:form method="post" action="add" modelAttribute="employee">
		<table>
			<tr>
				<td>Employee Name</td>
				<td><form:input path="name" /></td>
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