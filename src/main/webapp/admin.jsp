<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: homepc
  Date: 16.10.2018
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello ${name}</h1>
    <a href="/home">Checkout Page</a>
    <%--<form:select path="cinema">--%>
        <%--<c:forEach var="cinema" items="${cinemas}">--%>
            <%--<form:option value="${cinema}"> </form:option>--%>
        <%--</c:forEach>--%>
    <%--</form:select>--%>
    <form action="/home/admin" method="post">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>address</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <%--<td>start work time</td>--%>
                <%--<td><input type="time" name="startWorkTime"></td>--%>
                <%--<td>end work time</td>--%>
                <%--<td><input type="time" name="endWorkTime"></td>--%>
                <td colspan = "2"><input type = "submit" value = "add cinema"/></td>
            </tr>
        </table>
    </form>
    <form action="LogoutServlet" method="post">
        <input type="submit" value="Logout" >
    </form>
    <form>
        <h1>
            <font color="red">
                ${error}
            </font>
        </h1>
    </form>
</body>

