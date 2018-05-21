<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <p>Send message to the User: <a href="/usermessage"><button>click</button></a></p></br>
        <hr>
        <p>Tweets: </p>

        <table>
            <tr><th>Title</th><th>Tweet</th><th>Created</th><th>Comments</th></tr>
            <c:forEach items="${tweets}" var="tweet">
                <tr>
                    <td>${tweet.title}</td>
                    <td>${tweet.text}</td>
                    <td>${tweet.created}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
