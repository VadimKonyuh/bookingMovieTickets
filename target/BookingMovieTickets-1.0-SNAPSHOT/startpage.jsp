<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Booking ticket</title>
</head>
<body>
    <h1>Hello ${name}</h1>
    <form>
        <table>
            <tr>
                <td><b>Login</b></td>
                <td><input type = "text" name = "login"
                           value = "vadim" size = "70"/></td>
            </tr>

            <tr>
                <td><b>Password</b></td>
                <td><input type = "text" name = "password"
                           value = "vadim" size = "65"/></td>
            </tr>

            <table>
                <tr>
                    <form action="/mainServlet" method="post">
                    <td colspan = "2"><input type = "submit" value = "Login"/>${error}</td>

                    </form>
                    <form action="registration.jsp" method="post">
                    <td><td colspan = "2"><input type = "submit" value = "Registration"/></td></td>
                    </form>
                </tr>
            </table>

        </table>
    </form>
    <form action="/servlet" method="post">

    </form>

</body>
</html>
