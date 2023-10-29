<%--
  Created by IntelliJ IDEA.
  User: soraw
  Date: 10/29/2023
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List all student</title>
    <style>
        .table-data {
            display: flex;
        }
        table {
            margin: auto;
            display: -moz-inline-box;
            width: 80%;
            background-color: antiquewhite;
        }
        table tr {
            border-bottom-color: black;
        }
    </style>
</head>
<body>
<h1>Student list</h1>
<div class="table-data">
<table>
    <tr>
    <td>ID</td>
    <td>Name</td>
    <td>Score</td>
    <td>Grade</td>
    </tr>
    <c:forEach items="${sessionScope.studentWithGrade.entrySet()}" var="student" varStatus="ct">
        <tr>
            <td>${student.key.getId()}</td>
            <td>${student.key.getName()}</td>
            <td>${student.key.getScore()}</td>
            <td>${student.value}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
