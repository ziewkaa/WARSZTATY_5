<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet</title>
    <style>
        body {
            margin: 50px;
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
        input[type=submit]{
            display: block;
        }

        form , input[type=radio]{
            width: 150px;
            display: inline;
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

        <p>Delete Tweet:</p>

        <form action="/tweet/delete/${id}" method="post">
            <p>Are you sure you want to delete this tweet?</p></br>
            <span>Yes: <input type="radio" name="confirm" value="yes"></span></br>
            <span>No: <input type="radio" name="confirm" value="no" required></span>
            <input type="submit" value="confirm"/>
        </form>
    </body>
</html>
