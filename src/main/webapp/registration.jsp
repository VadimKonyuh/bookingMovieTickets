<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
     <form action="/registration" method="post">
        <center>
        <h1>Hello from jsp, fill in the fields to create an account</h1>

        <table>
            <tr>
                <td>Login</td>
                <td><input type = "text" name = "login" value = ${login}> </td>
            </tr>

            <tr>
                <td>Password</td>
                <td><input type = "text" name = "password" value = ${password}> </td>
            </tr>

            <tr>
                <td>Password</td>
                <td><input type = "text" name = "password1"> </td>
            </tr>

            <tr>
                <td>First name</td>
                <td><input type = "text" name = "firstName"> </td>
            </tr>

            <tr>
                <td>Last name</td>
                <td><input type = "text" name = "lastName"> </td>
            </tr>

            <tr>
                <td>email</td>
                <td><input type = "text" name = "eMail"> </td>
            </tr>

        </table>
            <tr>
                <td colspan = "2"><input type = "submit" value = "register"/></td>
            </tr>
        </center>
         <h1>
             <font color="red">
                 ${error}
             </font>
         </h1>
     </form>
</body>
</html>
