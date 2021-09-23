<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Register Page</title>
	</head>
	<body>
	<p>Register Page</p>
		<form action="RegisterLoginServlet?ac=register" method="post">
			Name : <input type=text name=name><br>
			DOB: <input type=text name=dob><br>
			Email : <input type=email name=email><br>
			Phone : <input type=text name=phone><br>
			User Name : <input type=text name=username><br>
			Password : <input type=password name=password><br>
			Type of User : <input type=text name=typeOfUser><br>
			Address : <input type=text name=address><br>
			Wallet: <input type=number name=wallet><br>
			<!-- value: It is displayed on the button -->
			<input type=submit value=Register>
		</form>
	</body>
</html>