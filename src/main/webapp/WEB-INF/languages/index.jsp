<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<table class="mt-5 table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Actions</th>
				</tr>		
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="lang">
				<tr>
					<td><a href="/languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
					<td><c:out value="${lang.creator}"/></td>
					<td><c:out value="${lang.version}"/></td>
					<td class="d-flex">
						<form class="me-3" method="post" action="/languages/${lang.id}">
							<input type="hidden" name="_method" value="delete"/>
							<input class="btn btn-outline-danger" type="submit" value="delete"/>
						</form>
						<a class="btn btn-outline-primary" role="button" href="/languages/${lang.id}/edit">edit</a>
					</td>
				</tr>			
				</c:forEach>
			</tbody>
		</table>
		
		<form:form action="/languages" method="post" modelAttribute="language" class="px-5 mt-5">
			<p class="row">
				<form:label path="name" class="form-label col">Name</form:label>
				<form:errors path="name"/>
				<form:input path="name" class="form-control col"/>
			</p>
			<p class="row">
				<form:label path="creator" class="form-label col">Creator</form:label>
				<form:errors path="creator"/>
				<form:input path="creator" class="form-control col"/>
			</p>
			<p class="row">
				<form:label path="version" class="form-label col">Version</form:label>
				<form:errors path="version"/>
				<form:input path="version" class="form-control col"/>
			</p>
			<p class="row justify-content-end">
				<input type="submit" value="Submit" class="btn btn-outline-primary" style="width:10%"/>			
			</p>
		</form:form>
	</div>
</body>
</html>