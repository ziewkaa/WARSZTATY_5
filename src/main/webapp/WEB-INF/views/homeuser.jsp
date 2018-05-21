<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweeter</title>
</head>
    <body>
        <ul>
            <li><a href="/logout">Log Out</a></li>
            <li><a href="/user/edit">Edit Account</a></li>
        </ul>
        <hr>
        <p>Add Tweet<a href="/tweet/add"><button>here</button></a></p>
        <hr>
        <p>Tweets</p>

        <table>
            <tr><th>Created</th><th>Title</th><th>Tweet</th><th>Comments</th><th>Action</th></tr>
            <c:forEach items="${tweets}" var="tweet">
                <tr>
                    <td>${tweet.created}</td>
                    <td>${tweet.title}</td>
                    <td>${tweet.text}</td>
                    <td>${count}</td>
                    <td><a href="/tweet/delete/${tweet.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
