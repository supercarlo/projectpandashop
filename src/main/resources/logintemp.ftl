<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="collapse navbar-collapse" align="right">
    <ul>
        <li>
            <form name="loginForm" method="post" action="/login">
                <input type="text" name="Username" placeholder="Username" required>
                <input type="text" name="Password" placeholder="Password" required>
                <input type="submit" value="Login">
            </form>
        </li>
        <li>
            <form name="registerForm" method="get" action="register.ftl">
                <input type="submit" value="Register">
            </form>
        </li>
    </ul>
</div>
</body>
</html>