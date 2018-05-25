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
            <li><a href="/">Home page</a></li>
            <li><a href="/user/edit">Edit Account</a></li>
            <li><a href="/user/tweets">My Tweets</a></li>
            <li><a href="/message/all">My Messages</a></li>
            <li><a href="/logout">Log Out</a></li>
        </ul>

        <hr>

        <p>Message: </p>

        <table>
            <tr><th>Created</th><th>Sender</th><th>Content</th></tr>
            <tr>
                <td>${message.created}</td>
                <td>${message.sender.mail}</td>
                <td>${message.content}</td>
            </tr>
        </table></br>

        <p>Reply: <a href="/message/new/${message.sender.id}"><button>send</button></a> </p>

    </body>
</html>
