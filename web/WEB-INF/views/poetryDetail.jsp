<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pagulane
  Date: 26.03.16
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Poetry Detail</title>
    <link href="/unnamed/static/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
    <a href="/unnamed/poetry/s">Servlet</a>
    <a href="/unnamed/log">Log</a>

    <div class="plane-detail-container">

        <form action="?action=save" method="POST">
            <c:forEach items="${errorList}" var="error">
                <p style="color: red;"><c:out value="${ error }"/></p>
            </c:forEach>
            <table>
                <tr>
                <label>Title</label>
                    <input name="id" type="hidden" value="${ poetry.id }">
                    <input name="title" type="text" value="${ poetry.title }">
                </tr>
                <tr>
                    <label>Content</label>
                    <input rows="30" name="content" type="text" value="${ poetry.content }">
                </tr>
                <tr>
                    <label>Date</label>
                    <input name="year" type="number" value="${ poetry.year }">
                </tr>
                <input type="submit" value="Submit">
            </table>
        </form>

    </div>
</body>
</html>
