<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer-list</title>
<link type="text/css" 
      rel="stylesheet" 
      href="${pageContext.request.contextPath}/resources/css/style.css" >
      
</head>
<body>
	<div id="wraper">
		<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
		<!-- <h4>${pageContext.request.contextPath}</h4> -->
		</div>
	</div>
	
	<!-- Add to button  -->
	
	<button type="button" onclick="window.location.href='showSaveForm'">Add Customer</button>

	<div id="container">
		<div id="content">
			<!-- Add our HTML Table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
					<th>Button Action</th>
				</tr>
				<!-- Loop over and print customer -->
				<c:forEach var="tmpCustomer" items="${customers}">
				
				<c:url var="updateLink" value="/customer/showUpdateForm">
				    <c:param name="customer_id" value="${tmpCustomer.id}"/>
				</c:url>
				
				<c:url var="deleteLink" value="/customer/deleteCustomer">
				  <c:param name="customer_id" value="${tmpCustomer.id}"/>
				</c:url>
				
					<tr>
						<td>${tmpCustomer.firstName}</td>
						<td>${tmpCustomer.lastName}</td>
						<td>${tmpCustomer.email}</td>
						<td>
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}" 
						   onclick="if(!(confirm('Are you sure..you want to delete this Customer ?'))) return false">Delete</a>
						</td>
						
						<td>
						<form action="updateForm" method="post">
						<input type="hidden" name="id" value="${tmpCustomer.id}" />
						<input type="submit" value="Update" />
						</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>