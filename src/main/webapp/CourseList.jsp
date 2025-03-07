<%@ page import="com.example.demo.bean.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 15/02/2025
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Cours List</h2>

    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name of course</th>


        </tr>
        </thead>
        <tbody>
        <%
            List<Course> courseList = (List<Course>) request.getAttribute("courselist");
            for (Course course : courseList) {
        %>
        <tr>
            <td><%= course.getCourseid() %></td>
            <td><%= course.getCoursename() %></td>


            <td>
                <a href="CourseServlet?action=edit&courseid=<%= course.getCourseid() %>" class="btn btn-warning btn-sm">Edit</a>
                <a href="CourseServlet?action=delete&courseid=<%= course.getCourseid()%>" class="btn btn-danger btn-sm">Delete</a>



            </td>
        </tr>
        <%

            }
        %>
        </tbody>
    </table>

    <a href="CourseForm.jsp" class="btn btn-success">Add new cours</a>
</div>


</body>
</html>
