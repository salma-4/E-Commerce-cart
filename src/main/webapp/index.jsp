<%@page import="models.Products"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>

<%
List<models.Products> products = (List<Products>) request.getSession().getAttribute("product");
Users user1 = (Users) request.getSession().getAttribute("user");
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome to our E-commerce</title>
<%@include file="includes/header.jsp"%>
<style>
body {
	font-family: Arial, sans-serif;
}

.message-container {
	max-width: 50%;
	margin: 0 auto;
}

.alert {
	margin-bottom: 10px;
}

.ok-link {
	float: right;
}
</style>
</head>
<body>
	<!-- message pop -->
	<div class="message-container">
		<%
		String successMessage = (String) request.getAttribute("successMessage");
		if (successMessage != null) {
		%>
		<div class="alert alert-success" role="alert">
			<%=successMessage%>
			<a href="index.jsp" class="ok-link">OK</a>
		</div>
		<%
		}
		%>

		<%-- Display error message --%>
		<%
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (errorMessage != null) {
		%>
		<div class="alert alert-danger" role="alert">
			<%=errorMessage%>
			<a href="index.jsp" class="ok-link">OK</a>
		</div>
		<%
		}
		%>
	</div>
	<%--navbar section --%>
	<%@include file="includes/navBar.jsp"%>

	<div class="container">
		<div class="card-header my-3">All products</div>
		<div class="row">
			<%
			if (products != null) {
				for (Products p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card  w-100" style="width: 18rem;">
					<img src="ProjectImages/<%=p.getImage()%>" class="card-img-top"
						alt="<%=p.getImage()%>">
					<div class="card-body">
						<h5 class="card-title"><%=p.getName()%></h5>
						<h6 class="price">
							Price:
							<%=p.getPrice()%></h6>
						<h6 class="category">
							Category:
							<%=p.getCategory()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<%
							if (user1 == null) {
							%>
							<a href="login.jsp" class="btn btn-primary">Add To cart</a>

							<%
							} else {
							%>
							<a href="AddToCart?id=<%=p.getId()%>" class="btn btn-primary">Add
								To cart</a>
							<%
							}
							%>
							<a href="#" class="btn btn-primary">Buy now</a>
						</div>
					</div>
				</div>
			</div>

			<%
			}
			} else {
			out.println("<h1>No Products available</h1>");
			}
			%>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>
