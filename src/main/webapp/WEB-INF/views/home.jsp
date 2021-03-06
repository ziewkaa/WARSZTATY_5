<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweeter</title>
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
    </style>
</head>
    <body>
        <ul>
            <li><a href="/login">Log In</a></li>
            <li><a href="/user/add">Sign Up</a></li>
        </ul>

        <hr>

        <p>Recent Tweets</p>

        <table>
            <tr><th>Title</th><th>Author</th><th>Tweet</th><th>Details</th></tr>
            <c:forEach items="${tweets}" var="tweet">
                <tr>
                    <td>${tweet.created}</td>
                    <td>${tweet.user.email}</td>
                    <td>${tweet.title}</td>
                    <td><a href="/tweet/details/${tweet.id}">Link</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
