<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Booking ticket</title>
</head>
<body>
    <h1>Hello ${name}</h1>
    <form action = "servlet-parameters" method = "GET">
        <table border = "0">

            <tr>
                <td><b>Login</b></td>
                <td><input type = "text" name = "login"
                           value = "1000" size = "70"/></td>
            </tr>

            <tr>
                <td><b>Password</b></td>
                <td><input type = "text" name = "password"
                           value = "" size = "65"/></td>
            </tr>
            <tr>
                <td colspan = "2"><input type = "submit" value = "Start test"/></td>
            </tr>
        </table>
    </form>

</body>
</html>
