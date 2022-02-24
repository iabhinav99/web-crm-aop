<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer-form</title>
<link type="text/css" 
      rel="stylesheet" 
      href="${pageContext.request.contextPath}/resources/css/style.css" >
      
</head>
<body>
	<div id="wraper">
		<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
		 <h4>Add a Customer..</h4>
		</div>
	</div>
	
	
	<div id="container">
		<div id="content">
		<form:form action="processForm" modelAttribute="customerform" method="POST">
		
		<form:hidden path="id"/>
		
		First Name : <form:input path="firstName"/> <br><br>
		Last  Name : <form:input path="lastName"/> <br><br>
		Email      : <form:input type="email" path="email"/>  <br><br>
		
		<input type="submit" value="Save" />
		
		</form:form>	
		</div>
		
		<p>
		<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	</div>
</body>
</html>