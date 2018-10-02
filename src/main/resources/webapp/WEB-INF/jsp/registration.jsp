<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang = "en">


<head>
    <link href="css/register.css" rel="stylesheet">
    <title>Registration</title>
</head>

<body>

    <%@include file="../common/navigation.jsp"%> /** notice that only owner can register new users, so others dont see register ref **/

    <div class="register-box login-box">
        <h1>Registration</h1>

        <form name="register" action="../register" method="POST">
            <p>First Name</p>
            <input type="text" name="person.firstName" placeholder="input First Name" required pattern="[A-Z]{1}[a-z]+">

            <p>Second Name</p>
            <input type="text" name="person.secondName" placeholder="input Second Name" required pattern="[A-Z]{1}[z-z]+">

            <p>Login</p>
            <input type="text" name="login" placeholder="input login (3 chars are min)" minlength="3">

            <p>Password</p>
            <input type="password" id="password" name="password" placeholder="input password (3 chars are min)" minlength="3">
            <p>Notice, that you type your password only once. Check it twice </p>
            <br>

            <input type="submit" name="submit" value="register">
        </form>
    </div>


</body>

</html>