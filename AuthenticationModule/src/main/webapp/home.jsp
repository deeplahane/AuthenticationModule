<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.entities.User"%>
<%@page import="com.entities.Message"%>

<%
User user = (User) session.getAttribute("user-obj");

if (user == null) {
	Message msg=new Message("Please Login First...","alert-danger");
	session.setAttribute("msg", msg);
	response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
		<a class="navbar-brand" href="index.jsp">My App</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active elementss"><a class="nav-link "
					href="home.jsp"><span> Home</span> <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item active elementss"><a class="nav-link"
					href="login.jsp"><span>Login</span></a></li>

				<li class="nav-item active elementss"><a class="nav-link "
					href="register.jsp"><span>Register</span></a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0 search-btn ">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-light my-2 my-sm-0" type="submit">
					<span>Search</span>
				</button>
			</form>
		</div>
	</nav>
	<!-- navbar end -->

	<!-- body start -->
	<div class="container ">
		<div class="row">
			<div class="col-md-6 offset-md-3 mt-4">

				<%
				User user1 = (User) session.getAttribute("user-obj");
				%>
				<%
				if (user != null) {
				%>
				<div class="card">
					<div class="card-header"
						style="display: flex; align-items: center; justify-content: center">
						<h2 style="color: #454545;">User Details</h2>

					</div>
					<div class="card-body ">
						<h3 style="color: #757575;">
							Name:

							<%=user1.getName()%></h3>
						<h3 style="color: #757575;">
							Email :
							<%=user1.getEmail()%></h3>
					</div>
					<div class="card-footer"
						style="display: flex; align-items: center; justify-content: center">
						<a href="logoutServlet" class="btn btn-primary lg">Logout</a>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</div>

	<!-- body end -->

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>


</body>
</html>