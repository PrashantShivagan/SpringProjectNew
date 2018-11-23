<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="w" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<Table>
<tr>
<th>Transaction Id</th>
<th>Transaction MobileNo</th>
<th>Transaction Type</th>
<th>Transaction Amount</th>
<th>Transaction Date</th>
</tr>

<w:forEach var="tra" items="${result}">
<tr>
<td>${tra.tranId}</td>
<td>${tra.mobileNumber}</td>
<td>${tra.tranType}</td>
<td>${tra.amount}</td>
<td>${tra.tranDate}</td>

</w:forEach>
</Table>
</body>
</html>