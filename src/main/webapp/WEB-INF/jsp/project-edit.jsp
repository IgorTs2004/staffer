<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Edit Project</title>
</head>

<body>
	<h2>Edit Project: ${project.name}</h2>

	<form:form method="post" action="project-edit/update"
		modelAttribute="project">
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
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>