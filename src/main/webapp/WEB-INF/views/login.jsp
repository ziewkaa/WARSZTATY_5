<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
</head>
    <body>

        <p>Sign Up: <a href="/add">here</a></p>
        <hr>

        <p>User sign in:</p>

    <form:form method="post" modelAttribute="user">

        <label>E-Mail:
            <form:input path="email" /></label>
            <form:errors path="email"/>
        <label>Password:
            <form:input path="password" /></label>
            <form:errors path="password"/>
        <input type="submit" value="save">

    </form:form>
    </body>
</html>
