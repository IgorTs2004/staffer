<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Project List from Web Service</title>
</head>

<body>
	<h2>Project List from Web Service</h2>

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
			</tr>
		</c:forEach>
	</table>

</body>
</html>