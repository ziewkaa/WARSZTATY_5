<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweeter</title>
</head>
    <body>

        <p><a href="/login">Log In</a></p>
        <p><a href="/user/add">Create Account</a></p>
        <hr>
        <p>Recent Tweets</p>

        <table>
            <tr><th>ID</th><th>Title</th><th>Tweet</th></tr>
            <c:forEach items="${tweets}" var="tweet">
                <tr>
                    <td>${tweet.id}</td>
                    <td>${tweet.title}</td>
                    <td>${tweet.text}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
