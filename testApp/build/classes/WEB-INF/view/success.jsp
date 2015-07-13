<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>course management</title>
<style type="text/css">
h2{
	color: blue;
}
button {
	margin-left: 45%; border-radius: 25px; width: 200px;
}
</style>
</head>
<body>
	<h2 align="center">Course Completion</h2>
	<form action="/testApp">
		<button type="submit" id="menu"
			style="margin-left: 45%; border-radius: 25px; width: 200px;">Go
			Back to Menu</button>
		<br />
	</form>
	<form action="regit">
		<button type="submit" id="input"
			style="margin-left: 45%; margin-top: 5px; border-radius: 25px; width: 200px;">Course
			Input</button>
	</form>
</body>
</html>