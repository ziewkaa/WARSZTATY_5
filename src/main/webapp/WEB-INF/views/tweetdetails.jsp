<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweeter</title>
</head>
<body>
<%@include file="header.jsp"%>
<hr>
<p>Tweet: </p>

<table>
    <tr><th>Title</th><th>Author</th><th>Content</th><th>Created</th><th>Actions</th><th>Comments</th></tr>
    <c:forEach items="${tweets}" var="tweet">
        <tr>
            <td>${tweet.title}</td>
            <td>${tweet.user_id}</td>
            <td>${tweet.text}</td>
            <td>${tweet.created}</td>
            <td><a href="/delete/tweet/${tweet.id}">Delete</a> / <a href="/edit/tweet/${tweet.id}">Edit</a></td>
            <%--<td>${comments}</td>--%>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp"%>
</body>
</html>
