<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Login Page</title>
	</head>
	<body>
	<p>Login Page</p>
		<form action="../GlobalServlet?ac=login" method="post">
			User Name : <input type=text name=username><br>
			Password : <input type=password name=password><br>
			<!-- value: It is displayed on the button -->
			<input type=submit value=Login>
		</form>
	</body>
</html>