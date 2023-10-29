<%--
  Created by IntelliJ IDEA.
  User: soraw
  Date: 10/29/2023
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add or Remove Student</title>
</head>
<body>
<h1>SitSpaceManagement</h1>
<div class="pages">
    <a href="./addRemoveStudent.jsp">Add or remove student</a>
    <a href="./listAllStudent.jsp">List of all student</a>
</div>
<div class="add-student-data">
    <h2>Adding new student</h2>
    <form action="student-management" method="post">
        <label for="std-id">ID:</label><input type="text" name="studentId" id="std-id"> <br>
        <label for="std-name">Name:</label><input type="text" name="studentName" id="std-name"> <br>
        <label for="std-score">Score:</label> <input type="text" name="studentScore" id="std-score"> <br>
        <input type="submit" value="Save students">
    </form>
</div>
<div class="remove-student">
    <form action="student-management" method="get">
        <label for="remove-id"> ID:</label><input type="text" name="removeId" id="remove-id">
        <input type="submit" name="remove" value="Remove Student">
    </form>
</div>
</body>
</html>
