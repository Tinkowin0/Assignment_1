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
		<h2>Teacher ${openC.teacher }</h2>
		<h2>Add New Student for ${cn}</h2>
		<div class="row">
			<div class="col-4">
				<c:url var="input" value="/registration">
				</c:url>
				<form action="${input }" method="post">
					<div class="mb-3">
						<label class="form-label">Student Name</label> <input type="text"
							name="student" placeholder="Enter student name"
							required="required" class="form-control" />
					</div>
					<div class="mb-3">
						<input type="number" name="cou" value="${openC.id }"
							hidden="hidden" class="form-control" />
					</div>
					<div class="mb-3">
						<input type="text" name="courseName" value="${cn }"
							hidden="hidden" class="form-control" />
					</div>
					<div class="mb-3">
						<input type="number" name="courseIDD" value="${cc }"
							hidden="hidden" class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label">Phone </label> <input type="text"
							name="phone" placeholder="Enter Phone number" required="required"
							class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label">Email</label> <input type="text"
							name="email" placeholder="Enter email " required="required"
							class="form-control" />
					</div>
					<input type="submit" value="Register" class="btn btn-primary" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>