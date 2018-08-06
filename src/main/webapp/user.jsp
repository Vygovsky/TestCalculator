<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
<table border="1" cellpadding="5">
    <caption><h2>List of users</h2></caption>
    <tr>
        <th>UserName</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user}"/></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href='http://localhost:8080/test'>На главную</a>


</body>
</html>