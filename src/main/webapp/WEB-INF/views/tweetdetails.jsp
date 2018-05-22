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

        <p>Tweet: </p>

        <table>
            <tr><th>Title</th><th>Author</th><th>Content</th><th>Created</th></tr>
                <tr>
                    <td>${tweet.title}</td>
                    <td>${tweet.user.email}</td>
                    <td>${tweet.text}</td>
                    <td>${tweet.created}</td>
                </tr>
        </table></br>


        <p>Add comment: <a href="/comment/add/${tweet.id}"><button>here</button></a> </p>
        <hr>
        <p>Comments: </p>

        <table>
            <tr><th>Created</th><th>Content</th><th>Author</th></tr>
                <c:forEach items="${comments}" var="comment">
                    <tr>
                        <td>${comment.created}</td>
                        <td>${comment.text}</td>
                        <td>${comment.user.email}</td>
                    </tr>
                </c:forEach>
                </tr>
        </table>
    </body>
</html>
