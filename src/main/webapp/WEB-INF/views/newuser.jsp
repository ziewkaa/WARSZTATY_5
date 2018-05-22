<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User</title>
    <style>
        body {
            margin: 50px;
            text-decoration: none;
        }
        ul, li {
            list-style: none;
            display: inline-block;
            margin: 10px;
        }
        table, tr, th, td {
            margin: 10px;
            padding: 10px;
            border: 1px solid black;
        }
        td {
            max-width: 300px;
        }
        form , input{
            width: 150px;
            display: inline-block;
            margin: 10px 0 10px 0;
            padding: 10px 0 10px 0;
        }
    </style>
</head>
    <body>

    <ul>
        <li><a href="/login">Log In</a></li>
        <li><a href="/">Home Page</a></li>
    </ul>
    <hr>

    <p>Create Account:</p>

    <form:form method="post" modelAttribute="user">

        <label>First Name:
            <form:input path="firstName" /></label>
        <form:errors path="firstName"/>
        <label>Last Name:
            <form:input path="lastName" /></label>
        <form:errors path="lastName"/>
        <label>E-Mail:
            <form:input path="email" /></label>
        <form:errors path="email"/>
        <label>Password:
            <form:password path="password" /></label>
        <form:errors path="password"/>
        <input type="submit" value="save">

    </form:form>

    </body>
</html>
