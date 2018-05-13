<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <p>Edit Personal Details:</p>

        <<form:form method="post" modelAttribute="user">

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
