<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Hello ${name} from jsp</h1>
<table>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td><c:out value="${user.name}" /></td>
            <td><c:out value="${user.description}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
