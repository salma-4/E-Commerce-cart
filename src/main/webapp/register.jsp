<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="windows-1256">
<%@include file="includes/header.jsp"%>
<title>Register Page</title>
</head>
<body>
	<%@include file="includes/navBar.jsp"%>

	<br>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="RegisterCheck" method="post">
					<!-- Add Bootstrap form classes -->
					<div class="form-group">
						<label for="name">Name</label> <input id="name" type="text"
							name="name" placeholder="Enter your name" class="form-control"
							required>
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input id="email" type="email"
							name="email" placeholder="Enter your email" class="form-control"
							required>
					</div>
					<%-- Display email error message --%>
					<div style="color: red;">
						<%
						String errorMessage1 = (String) request.getAttribute("emailMessage");
						if (errorMessage1 != null && !errorMessage1.isEmpty()) {
							out.println(errorMessage1);
						}
						%>
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input id="password"
							type="password" name="password" placeholder="*********"
							class="form-control" required>

					</div>
					</div>
					<!-- Add spacing below the password input -->
					<div class="mb-3"></div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Register</button>
					</div>
				</form>
				<a href="login.jsp">Already have an account?</a>
			</div>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>
