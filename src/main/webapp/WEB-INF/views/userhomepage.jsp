<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <hr>
        <p>New Tweet:<a href="/newtweet"><button>here</button></a></p>
        <hr>
        <p>My Tweets: </p>
        <table>
            <tr><th>Title</th><th>Tweet</th><th>Comments</th></tr>
            <c:forEach items="${tweets}" var="tweet">
                <tr>
                    <td>${tweet.title}</td>
                    <td>${tweet.text}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
