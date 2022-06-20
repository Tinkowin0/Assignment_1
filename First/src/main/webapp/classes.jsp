<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using IOC Container</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-4 ">
		<h1>Using IOC Container</h1>
		<h2>Classes for ${ course.name }</h2>
		<div class="btn btn-warning">
			<c:url var="addNew" value="/class-edit">
				<c:param name="courseId" value="${course.id }"></c:param>
			</c:url>
			<a href="${addNew }"> ADD NEW Class</a>
		</div>
		<div class="btn btn-warning">
			<a href="/">Go Black HOME</a>
		</div>
		<div class="mt-4">
			<c:choose>
				<c:when test="${empty classes }">
					<div class="alert alert-warning">There is no class for
						${course.name } . Please create new class</div>
				</c:when>
				<c:otherwise>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Course</th>
								<th>Teacher</th>
								<th>Start Date</th>
								<th>Fees</th>
								<th>Duration</th>
								<th>Description</th>
								<th>Registration</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${classes }">
								<tr>
									<td>${c.id }</td>
									<td>${c.course.name }</td>
									<td>${c.teacher }</td>
									<td>${c.startDate }</td>
									<td>${c.course.fees }</td>
									<td>${c.course.duration }</td>
									<td>${c.course.description }</td>
									<td><c:url var="registration" value="/registration">
											<c:param name="cId" value="${c.id }"></c:param>
											<c:param name="courseIDD" value="${c.course.id }"></c:param>
											<c:param name="courseName" value="${c.course.name }"></c:param>
										</c:url> <a href="${ registration }">Registration</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>