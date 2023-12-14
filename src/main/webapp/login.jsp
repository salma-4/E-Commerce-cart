<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="windows-1256">
<%@include file="includes/header.jsp"%>
<title>Login Page</title>
</head>
<body>
	<%@include file="includes/navBar.jsp"%>
	<br>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div
				style="color: white; text-align: center; background-color: green;">
				<%
				String registerMessage = (String) request.getAttribute("registerMessage");
				if (registerMessage != null && !registerMessage.isEmpty()) {
					out.println(registerMessage);
				}
				%>
			</div>
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="LoginCheck" method="post">
					<!-- Add Bootstrap form classes -->
					<div class="form-group">
						<label for="email">Email</label> <input id="email" type="email"
							name="email" placeholder="Enter your email" class="form-control"
							required>
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input id="password"
							type="password" name="password" placeholder="*********"
							class="form-control" required>
					</div>
					<!-- Add spacing below the password input -->
					<div class="mb-3"></div>
					<!-- Display error messages here -->
					<%-- <div class="alert alert-danger" role="alert">
                        Incorrect email or password. </div> --%>
					<div style="color: red;">
						<%
						String errorMessage = (String) request.getAttribute("errorMessage");
						if (errorMessage != null && !errorMessage.isEmpty()) {
							out.println(errorMessage);
						}
						%>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>

				</form>
				<a href="register.jsp">you don't have account ?</a>
			</div>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>
