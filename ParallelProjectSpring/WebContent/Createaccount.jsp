<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="a"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h1 align="center">Create A New Account</h1>
<body>
<a:form action="adddata" method="post" modelAttribute="y">
<table align="center" border="2px">

<tr>
<td>Name</td>
<td><a:input path="name"/></td>
</tr>

<tr>
<td>Mobile No</td>
<td><a:input path="mobileno"/></td>
</tr>

<tr>
<td>Initial Balance</td>
<td><a:input path="bal"/></td>
</tr>

<tr>
<td>
<td align="right"><input type="submit" value="Add User"/>
</td>
</tr>
</table>
</a:form>
</body>
</html>