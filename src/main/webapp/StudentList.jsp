<%@ page import="com.example.demo.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list of students</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center mb-3">List of Students</h2>

    <table class="table table-bordered">
        <thead class="table-light">
        <tr>

            <th>Name</th>
            <th>Email</th>

        </tr>
        </thead>
        <tbody >
       <%
            List<Student> studentlist = (List<Student>) request.getAttribute("studentlist");
            for (Student student : studentlist) {
        %>
        <tr>

            <td><%= student.getName() %></td>
            <td><%= student.getEmail() %></td>
            <td>

                <a href="StudentServlet?act=edit&id=<%= student.getId() %>" class="btn btn-outline-primary btn-sm">
                    Update
                </a>

                <a href="StudentServlet?act=delete&id=<%= student.getId() %>" class="btn btn-outline-danger btn-sm">
                    Delete
                </a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>


    <div class="text-center">
        <a href="Studentform.jsp" class="btn btn-success">Add new student</a>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>