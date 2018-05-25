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
<p>Messages Sent: </p>

<table>
    <tr><th>Content</th><th>Sent</th><th>To</th><th>Details</th><th>Delete</th></tr>
    <c:forEach items="${messagesSent}" var="message">
        <tr>
            <td>${message.content}</td>
            <td>${message.created}</td>
            <td>${message.receiver.email}</td>
            <td><a href="/message/details/${message.id}">Link</a></td>
            <td><a href="/message/delete/${message.id}">Remove</a></td>

        </tr>
    </c:forEach>
</table>

<p>Messages Received: </p>

<table>
    <tr><th>Content</th><th>Received</th><th>From</th><th>Details</th><th>Delete</th></tr>
    <c:forEach items="${messagesReceived}" var="message">
        <tr>
            <td>${message.content}</td>
            <td>${message.created}</td>
            <td>${message.sender.email}</td>
            <td><a href="/message/details/${message.id}">Link</a></td>
            <td><a href="/message/delete/${message.id}">Remove</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
