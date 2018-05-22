<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
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
        <li><a href="/">Home page</a></li>
        <li><a href="/user/edit">Edit Account</a></li>
        <li><a href="/user/tweets">My Tweets</a></li>
        <li><a href="/message/all">My Messages</a></li>
        <li><a href="/logout">Log Out</a></li>
    </ul>
    <hr>
        <p>Tweets: </p>

        <table>
            <tr><th>Title</th><th>Tweet</th><th>Created</th><th>Details</th><th>Actions</th></tr>
            <c:forEach items="${tweets}" var="tweet">
                <tr>
                    <td>${tweet.title}</td>
                    <td>${tweet.text}</td>
                    <td>${tweet.created}</td>
                    <td><a href="/tweet/details/${tweet.id}">Link</a></td>
                    <td><a href="/tweet/delete/${tweet.id}">Delete</a> / <a href="/tweet/edit/${tweet.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
