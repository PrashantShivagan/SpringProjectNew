<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Deposit Amount in Account</h1>
<body>
<b:form action="depdata" method="post" modelAttribute="z">
<table align="center" border="2px">
<tr>
<td>Mobile No</td>
<td><b:input path="mobileno"/></td>
</tr>
<tr>
<td>Deposit Balance</td>
<td><b:input path="bal"/></td>
</tr>

<tr>
<td>
<td align="right"><input type="Submit" value="Deposit Amt"/>
</td>
</tr>
</table>
</b:form>
</body>
</html>