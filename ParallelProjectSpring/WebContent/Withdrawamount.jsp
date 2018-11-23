<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Withdraw Amount from Account</h1>
<body>
<c:form action="withdata" method="post" modelAttribute="e">
<table align="center" border="2px">
<tr>
<td>Mobile No</td>
<td><c:input path="mobileno"/></td>
</tr>

<tr>
<td>Withdraw Amount</td>
<td><c:input path="bal"/></td>
</tr>

<tr>
<td>
<td align="right"><input type="Submit" value="Withdraw Amt"/>
</td>
</tr>
</table>
</c:form>
</body>
</html>