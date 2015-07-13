<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript">
	
</script>
<style type="text/css">
h2{
	color: blue;
}
.required {
	color: red;
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
	<h2 align="center">Course Input</h2>
	<form:form commandName="courseDTO" name="courseForm" action="registration">
		<center>
			<table cellpadding="10">
				<tr>
					<td class="required">*Required items</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="err" style="background-color: yellow;">
							<form:errors id="validater" path="*" cssStyle="color : red;" />
						</div>
					</td>
				</tr>
				<tr>
					<td>Course Number <span class="required">*</span></td>
					<td><form:input path="courseNumber" /></td>
				</tr>
				<tr>
					<td>Course Name <span class="required">*</span></td>
					<td><form:input path="courseName" /></td>
				</tr>
				<tr>
					<td>Course Date <span class="required">*</span></td>
					<td><form:select path="year">
							<form:options items="${yearList}" />
						</form:select> <form:select path="month">
							<form:options items="${monthList}" />
						</form:select> <form:select path="day">
							<form:options items="${dayList}" />
						</form:select></td>
				</tr>
				<tr>
					<td>Time Of Open <span class="required">*</span></td>
					<td><form:select path="openHr">
							<form:options items="${hourList}" />
						</form:select> <form:select path="openMin">
							<form:options items="${minuteList}" />
						</form:select></td>
				</tr>
				<tr>
					<td>Time Of End <span class="required">*</span></td>
					<td><form:select path="endHr">
							<form:options items="${hourList}" />
						</form:select> <form:select path="endMin">
							<form:options items="${minuteList}" />
						</form:select></td>
				</tr>
				<tr>
					<td>Capacity <span class="required">*</span></td>
					<td><form:input path="capicity" /><span style="color: blue;">persons</span></td>
				</tr>
				<tr>
					<td align="right"><button type="button" onclick="goBack()">Back</button></td>
					<td><form:button type="submit">Confirm</form:button></td>
				</tr>
			</table>
		</center>
	</form:form>
</body>
</html>