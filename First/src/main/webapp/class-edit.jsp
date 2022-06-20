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
		<h2>Add New Class for ${course.name }</h2>
		<div class="row">
			<div class="col-4">
				<c:url var="creat" value="/classes">
				</c:url>
				<form action="${creat }" method="post">
					<div class="mb-3">
						<label class="form-label">Teacher Name</label> <input type="text"
							name="teacher" placeholder="Enter teacher name"
							required="required" class="form-control" />
					</div>
					<div class="mb-3">
						<input type="number" name="cou" value="${course.id }"
							hidden="hidden" class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label">Start Date</label> <input type="date"
							name="date" placeholder="Enter Start Date" required="required"
							class="form-control" />
					</div>
					<input type="submit" value="Save Class" class="btn btn-primary" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>