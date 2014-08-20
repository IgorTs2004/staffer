<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Project List</title>
</head>

<body>
	<h2>Project List</h2>

	<form:form method="post" action="project/add" modelAttribute="project">
		<table>
			<tr>
				<td>Project Name</td>
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
			<th>participants</th>
		</tr>
		<c:forEach items="${projects}" var="project">
			<tr>
				<td>${project.id}</td>
				<td>${project.name}</td>
				<td>
					<c:forEach items="${project.participants}" var="participant">
						${participant.name}<br>
					</c:forEach>
					<a href="project/manage-participants?id=${project.id}">Manage participants</a>
				</td>
				<td><a href="project/delete?id=${project.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>