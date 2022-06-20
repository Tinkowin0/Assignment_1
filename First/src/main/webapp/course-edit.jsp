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
		<h2>Add New Course</h2>
		<div class="row">
			<div class="col-4">
				<c:url var="save" value="/courses"></c:url>
				<form action="${save }" method="post">
					<div class="mb-3">
						<label class="form-label">Name</label> <input type="text"
							name="name" placeholder="Enter Course Name" required="required"
							class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label">Fees</label> <input type="number"
							name="fees" placeholder="Enter Course Fees" required="required"
							class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label">Duration</label> <input type="number"
							name="duration" placeholder="Enter Course Duration"
							required="required" class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label">Description</label>
						<textarea class="form-control" name="description" cols="30"
							rows="3"></textarea>
					</div>
					<input type="submit" value="Save Course" class="btn btn-primary" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>