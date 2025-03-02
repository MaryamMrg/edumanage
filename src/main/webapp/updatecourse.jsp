<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 27/02/2025
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
<%@ page import="com.example.demo.bean.Course" %><%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 19/02/2025
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mise a jour Formulaire</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Update Cours</h2>

    <%
        Course course = (Course) request.getAttribute("course");
    %>

    <form action="CourseServlet" method="post">
        <input type="hidden" name="courseid" value="<%= course.getCourseid() %>"/>
        <input type="hidden" name="action" value="update"/>

        <div class="form-group">
            <input type="text" class="form-control" name="coursename" value="<%=course.getCoursename() %>" required />
        </div>

        <button type="submit" class="btn btn-primary btn-block">Update</button>
    </form>


    <br>
    <a href="CourseServlet" class="btn btn-secondary"> <- list </a>
</div>

</body>
</html>
