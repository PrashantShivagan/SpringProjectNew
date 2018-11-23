<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="r" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Show Balance in Account</h1>
<body>
<r:form action="shodata" method="post" modelAttribute="f">
<table align="center" border="2px">
<tr>
<td>Mobile No</td>
<td><r:input path="mobileno"/></td>
</tr>
<tr>
<tr>
<td>
<td align="right"><input type="Submit" value="Show balance"/>
</td>
</tr>
</table>
</r:form>
</body>
</html>