<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet</title>
</head>
<body>

<p>Add Tweet:</p>

<form:form method="post" modelAttribute="tweet">

    <label>Title:
        <form:input path="title" /></label>
        <form:errors path="title"/>
    <label>Content:
        <form:input path="text" /></label>
        <form:errors path="text"/>
    <input type="submit" value="save">

</form:form>

</body>
</html>
