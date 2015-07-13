<html>
<head>
<script type="text/javascript">
	Document
	function go() {
		xmlhttp = new XMLHttpRequest();
		setTimeout(function() {
			window.location = "/testApp/regit"
		}, 5000);
	};
</script>
<style type="text/css">
h2{
	color: blue;
}
button {
	margin-left: 45%; border-radius: 25px; width: 200px;
}
</style>
<script src="<c:url value="resource/jquery-2.1.1.min.js" />"></script>
<!-- <script type="text/javascript" src="resource/script/jquery-2.1.1.min.js"></script> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Spring MVC</title>
</head>
<body onload="go()">
	<h2 align="center">Course Management Menu</h2>
	<p>
		Click 'Course Edit / Delete' Button.<br /> This page will forward to
		'Course Input' screen automatically in 5 seconds.
	</p>
	<form action="regit">
		<button type="submit" id="regit"
			style="">Course
			Registration</button>
		<br />
	</form>
	<form action="edit">
		<button type="submit" id="edit"
			style="margin-top: 5px;">Course
			Edit/Delete</button>
	</form>
</body>
</html>