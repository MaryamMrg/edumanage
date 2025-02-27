<%@ page import="com.example.demo.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update Student</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Update Student</h2>


    <form action="StudentServlet" method="post">
        <input type="hidden" name="act" value="update">
        <%
            Student student = (Student) request.getAttribute("student");
        %>

        <input type="hidden" name="id" value="<%= student.getId() %>">


        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="<%= student.getName() %>" >
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="text" class="form-control" id="email" name="email" value="<%= student.getEmail() %>" >
        </div>


        <div class="text-center">
            <button type="submit" class="btn btn-primary" >save</button>

        </div>
    </form>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>