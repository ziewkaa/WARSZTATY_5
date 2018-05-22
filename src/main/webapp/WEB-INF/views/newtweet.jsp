<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet</title>
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
            padding: 10px;
        }
    </style>
</head>
    <body>

        <ul>
            <li><a href="/">Home page</a></li>
            <li><a href="/user/edit">Edit Account</a></li>
            <li><a href="/user/tweets">My Tweets</a></li>
            <li><a href="/message/all">My Messages</a></li>
            <li><a href="/logout">Log Out</a></li>
        </ul>
        <hr>

        <p>Add Tweet:</p>

        <form:form method="post" modelAttribute="tweet">

            <label>Title:
                <form:input path="title" /></label>
                <form:errors path="title"/>
            <label>Content:</label></br>
                <form:textarea path="text" cols="100" rows="10"/>
                <form:errors path="text"/>
            <input type="submit" value="save">

        </form:form>

    </body>
</html>
