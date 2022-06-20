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
		<h2>${cn }of Students</h2>
		<div class="btn btn-warning">
			<c:url var="Add" value="/reg-edit">
				<c:param name="cId" value="${openC.id }"></c:param>
				<c:param name="courseName" value="${cn }"></c:param>
				<c:param name="courseIDD" value="${cc }"></c:param>
			</c:url>
			<a href="${Add }"> ADD NEW STUDENT</a>
		</div>
		<div class="btn btn-warning">
			<c:url var="addNew" value="/classes">
				<c:param name="courseId" value="${cc }"></c:param>
			</c:url>
			<a href="${addNew }"> Go BlackClass</a>
		</div>
		<div class="mt-4">
			<c:choose>
				<c:when test="${empty registration }">
					<div class="alert alert-warning">There is no student for ${cn }
						.Please create new student</div>
				</c:when>
				<c:otherwise>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Stud_Name</th>
								<th>Stud_Phone_NO</th>
								<th>Stud_Email</th>
								<th>Teacher</th>
								<th>Start_Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${registration }">
								<tr>
									<td>${c.id  }</td>
									<td>${c.student }</td>
									<td>${c.phone }</td>
									<td>${c.email }</td>
									<td>${c.openClass.teacher }</td>
									<td>${c.openClass.startDate }</td>
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