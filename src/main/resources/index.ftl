<!DOCTYPE html>
<html lang="en">
<body>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/shop-homepage.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</body>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.js"></script>

</head>
<body>

<#include "/navbar.ftl">


        <#include "/panda123.ftl">
            <#include "/homepage.ftl">


    <#if test2 == 1>
        <#include "/panda123.ftl">
            <#include "/register.ftl">
    </#if>
    <#include "/footer.ftl">
        <#--<button test = 2></button>-->
        ${test}
</body>

</html>