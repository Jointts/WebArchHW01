<%--
  Created by IntelliJ IDEA.
  User: pagulane
  Date: 26.03.16
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Poetry List</title>
    <script src="/unnamed/static/js/jquery-1.12.2.min.js"></script>
    <script src="/unnamed/static/js/form.js"></script>
    <link href="/unnamed/static/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>

    <div class="plane-list-container">
        <a href="/unnamed/poetry/s">Servlet</a>
        <a href="/unnamed/log">Log</a>
        <table>
            <tr>
                <th>Code</th>
                <th>Title</th>
                <th>Year</th>
            </tr>
            <c:forEach items="${poetryList}" var="poetry">
                <tr>
                    <td><c:out value="${poetry.id}"/></td>
                    <td><c:out value="${poetry.title}"/></td>
                    <td><c:out value="${poetry.year}"/></td>
                    <td><input type="button" value="Description" onclick="showForm(${poetry.id})"></td>
                    <td><a href="/unnamed/poetry/s?id=${poetry.id}"><input type="button" value="Edit"></a></td>
                </tr>
            </c:forEach>
        </table>
        <div class="poetryDetail"></div>
    </div>
</body>
</html>
