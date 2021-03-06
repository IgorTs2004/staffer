<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Project List</title>
</head>

<body>
	<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
	
	<h2>Project List</h2>

	<security:authorize ifAllGranted="ROLE_MANAGER">
	<form:form method="post" action="project/add" modelAttribute="project">
		<table>
			<tr>
				<td>Project Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Participants</td>
				<td>
					<form:select path="participants" multiple="true"
						items="${allEmployees}" itemValue="id" itemLabel="name" />
				</td>
			</tr>			
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
	</security:authorize>

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
				</td>
				<security:authorize ifAllGranted="ROLE_MANAGER">
				<td><a href="project-edit?projectId=${project.id}">Edit</a></td>
				<td><a href="project/delete?id=${project.id}">Delete</a></td>
				</security:authorize>
			</tr>
		</c:forEach>
	</table>
</body>
</html>