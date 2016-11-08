<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#assign test = 1>
<#assign test2 = 1>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/main">Pandashop</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/about">About</a>
                </li>
                <li>

                    <a href="/login">Login</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
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
                        <form name="registerForm" method="get">
                            <input type="submit" value="Register" action="" onclick=<#assign test = 2>>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
</body>
</html>