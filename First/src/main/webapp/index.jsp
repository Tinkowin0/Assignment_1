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
	<div class="container mt-4">
		<h1>Using IOC Container</h1>
		<h2>Courses</h2>
		<div class="btn btn-warning">
			<a href="course-edit"> ADD NEW COURSE</a>
		</div>
		<div class="mt-4">
			<c:choose>
				<c:when test="${empty course }">
					<div class="alert alert-warning">There is no course. Please
						create new course.</div>
				</c:when>
				<c:otherwise>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Durations</th>
								<th>Fees</th>
								<th>Description</th>
								<th>OpenClasses</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${ course }">
								<tr>
									<td>${c.id }</td>
									<td>${c.name }</td>
									<td>${c.duration }Months</td>
									<td>${c.fees }</td>
									<td>${c.description }</td>
									<td><c:url var="classes" value="/classes">
											<c:param name="courseId" value="${c.id }"></c:param>
										</c:url> <a href="${ classes}">Open Classes</a></td>
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