<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Title</title>
</head>
<body>
<h1>Hello ${user}</h1>
<a href="<c:url value="/logout" />">Logout</a>
<form action="/admin" method="post">
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
            <td colspan = "2"><input type = "submit" name="button" value = "add cinema"/></td>
        </tr>
    </table>
    <table>
        <tr>
            <td>Select cinema</td>
            <td>
                <select name="cinemaId">
                    <option disabled>Выберите кинотеатр</option>
                    <c:forEach items="${CinemaList}" var="cinema">
                        <option value=${cinema.id} >Name:${cinema.name}  ${cinema.address}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>new Name</td>
            <td><input type="text" name="newName"></td>
        </tr>
        <tr>
            <td>new Address</td>
            <td><input type="text" name="newAddress"></td>
        </tr>
        <tr>
            <td colspan = "2"><input type = "submit" name="button" value = "cinema update"/></td>
        </tr>
    </table>
</form>

<form action="/logout" method="get">
    <input type="submit" value="Logout" >
</form>
<form>
    <h1>
        <font color="red">
            ${error}
        </font>
    </h1>
</form>
<form>
    <center>
        <c:forEach items="${CinemaList}" var="cinema">
            <table>
                <tr>
                    <td>${cinema.getId()}</td>
                    <td>${cinema.getName()}</td>
                    <td>${cinema.getAddress()}</td>
                    <td>
                        <p>
                            <input type="checkbox" name="cinemaId" id="cinemaId" value = "${cinema.getId()}" />
                        </p>
                    </td>
                </tr>
            </table>
        </c:forEach>
        <form action="home/admin" method="post">
            <input type="submit" value="Delete cinemas" >
        </form>
    </center>
</form>
</body>
