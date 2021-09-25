<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seller Page</title>
</head>
<body>
	<p>Inside seller page</p>
		<form action="GlobalServlet?ac=addproduct" method="post">
			Name : <input type=text name=productname><br>
			Category: <input type=text name=category><br>
			Description : <input type=text name=description><br>
			Actual price : <input type=number name=price><br>
			Quantity : <input type=number name=quantity><br>
			Image : <input type=text name=image><br>
			<input type=submit value=Add>
		</form>
		
		<form action="GlobalServlet?ac=displayseller" method="post">
			<input type=submit value=Display>
		</form>
		
		Name: ${ object.name } <br>
		Email: is ${ object.email } <br>
		Phone Number: is ${ object.phoneNumber } <br>
		Last Logged-in is ${ object.lastloggedin }
		
		<form action="GlobalServlet?ac=scheduleauction" method="post">
			Product : <input type=text name=productname><br>
			Minimum bid value: <input type=number name=minbid><br>
			Bid start : <input type=date name=bidstart><br>
			Bid end : <input type=date name=bidend><br>
		<input type=submit value=Schedule>
		</form>
	</body>
</html>