<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
    <link href="css/auth.css" rel="stylesheet">
    <title>Auth page</title>
</head>

<body>

    <div class="login-box">

        <h1>Authorisation</h1>

        <form name="loginForm" action="../login" method="post">
            <p>Login</p>
            <input type="text" name="login" placeholder="input login" required>
            <p>Password</p>
            <input type="password" name="password" placeholder="input password" required>
            <br>
            <input type="submit" name="submit" value="login">

        </form>
    </div>

</body>

</html>