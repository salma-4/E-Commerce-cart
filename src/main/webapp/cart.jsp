<%@page import="models.Users"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>CartPage</title>
<link rel="stylesheet" type="text/css" href="cart.css">
<%@include file="includes/header.jsp" %>
</head>
<body>
<%@include file="includes/navBar.jsp" %>
<%Users user1= (Users)request.getSession().getAttribute("user"); %>
<%if(user1==null){
	response.sendRedirect("login.jsp");
	
} %>
<div class="container">
<div class="d-flex py-3">
	<h3>Total price : $</h3>
	<a class="mx-3 btn btn-primary" href="#">Check Out</a>
</div>
<table class="table table-loght">
<thead>
<tr>
<th scope="col">Name</th>
<th scope="col">Category</th>
<th scope="col">Price</th>
<th scope="col">Buy Now</th>
<th scope="col">Cancle</th>
</tr>
</thead>
<tbody>
<tr>
<td>nn</td>
<td>nn</td>
<td>nn</td>
<td> 
<form method="post" class="form-inline" >
<input type="hidden" name="id" value="1" class="form-input" readonly>
<div class="form-group d-flex justify-content-between">
<a class="btn btn-sm btn-incre"><i class="fas fa-plus-square" style="box-shadow: none;font-size: 25px; color:#78C1F3;"  ></i></a>
<input type="text" name="quantity" value="1" class="form-input" readonly style=" background-color: #EEF0E5;">
<a class="btn btn-sm btn-decre"><i  class="fas fa-minus-square" style="box-shadow: none;font-size: 25px; color:#78C1F3;"  ></i></a>

</div>
</form>
</td>
<td><a class="btn btn-sm btn-danger">Remove</a></td>
</tr>
</tbody>

</table>
</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>