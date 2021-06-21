<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Language</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
</head>
<body>
	<div class="container">
		<div>
			<h3><a href="/languages">Dashboard</a></h3>
		</div>
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language" class="px-5 mt-5">
			<input type="hidden" name="_method" value="put" />
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