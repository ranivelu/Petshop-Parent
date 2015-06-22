<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User App</title>
</head>
<body>
	<center>		
		<h3>
			Dear ${name}, ${message} 
		</h3>
		
		<h5>Sogeti Netherland Pets Shopping Applications, has various pet food products based on stock availabilities.</h5>
		
		<h5>Please share your concerns & feedback with us email : <a href="mailto:support@petshop.com">support@petshop.com</a></h5>
		
		Click to visit <a href="${pageContext.request.contextPath}/">Main page</a>
		
	</center>
</body>
</html>