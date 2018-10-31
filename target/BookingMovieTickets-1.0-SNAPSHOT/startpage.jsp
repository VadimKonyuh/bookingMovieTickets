<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Booking ticket</title>
</head>
<body>
    <h1>Hello ${name}</h1>
        <form action="/login" method="post">
            <table>
                <tr>
                    <td><b>Login</b></td>
                    <td><input type = "text" name = "login"
                               value = "vadim" size = "70"/></td>
                </tr>

                <tr>
                    <td><b>Password</b></td>
                    <td><input type = "password" name = "password"
                               value = "vadim" size = "65"/></td>
                </tr>

                <table>
                    <tr>
                        <form action="/login" method="post">
                        <td colspan = "2"><input type = "submit" value = "Login"/></td>
                        </form>


                        <form action="/registration">
                        <td colspan = "2"><input type = "submit" value = "Registration"/></td>
                        </form>
                    </tr>
                </table>
            </table>
        </form>
</body>
</html>
