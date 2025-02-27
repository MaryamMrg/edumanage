<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25/02/2025
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />

</head>
<body class="bg-light" >
<div class="text-center mb-4">
    <h1 class="fw-bold">Welcome to Students Management</h1>
    <h2 class="text-muted"> add New Student</h2>
</div>
<div class="container my-5" >
    <form action="StudentServlet" method="post">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" name="name">
        <label for="email" class="form-label">email</label>
        <input type="text" class="form-control" id="email" name="email">
       <button type="submit" class="btn btn-primary">add student</button>

    </form>

</div>

</body>
</html>
