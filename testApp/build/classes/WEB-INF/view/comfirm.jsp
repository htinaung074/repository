<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>course management</title>
<style type="text/css">
h2{
	color: blue;
}
.label {
	color: blue;
}
button {
	border-radius: 25px; width: 200px;
}
</style>
<script type="text/javascript">
	function goBack() {
		window.history.back()
	}
</script>
</head>
<body>
	<h2 align="center">Course Confirmation</h2>
	<center>
		<form:form commandName="courseDTO" action="comfirm" name="comfirm">
			<table cellpadding="10">
				<tr>
					<td class="label">Course Number</td>
					<td>${courseDTO.courseNumber}<form:hidden path="courseNumber" value="${courseDTO.courseNumber}" /></td>
				</tr>
				<tr>
					<td class="label">Course Name</td>
					<td>${courseDTO.courseName}<form:hidden path="courseName" value="${courseDTO.courseName}" /></td>
				</tr>
				<tr>
					<td class="label">Course Date</td>
					<td>${courseDTO.year}/${courseDTO.month}/${courseDTO.day}
					<form:hidden path="year" value="${courseDTO.year}" />
					<form:hidden path="month" value="${courseDTO.month}" />
					<form:hidden path="day" value="${courseDTO.day}" /></td>
				</tr>
				<tr>
					<td class="label">Time Of Open</td>
					<td>${courseDTO.openHr}:${courseDTO.openMin}
					<form:hidden path="openHr" value="${courseDTO.openHr}" />
					<form:hidden path="openMin" value="${courseDTO.openMin}" /></td>
				</tr>
				<tr>
					<td class="label">Time Of End</td>
					<td>${courseDTO.endHr}:${courseDTO.endMin}
					<form:hidden path="endHr" value="${courseDTO.endHr}" />
					<form:hidden path="endMin" value="${courseDTO.endMin}" /></td>
				</tr>
				<tr>
					<td class="label">Capacity</td>
					<td>${courseDTO.capicity}persons
					<form:hidden path="capicity" value="${courseDTO.capicity}" /></td>
				</tr>
				<tr>
					<td align="right"><button type="button" onclick="goBack()">Back</button></td>
					<td><form:button type="submit">Confirm</form:button></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>