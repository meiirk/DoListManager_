<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="head.jsp" %>
    <title> Task system</title>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp" %>
    <div class="row">
        <div class="col">
            <form action="/add" method="post">
                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input type="text" class="form-control" name="name">
                </div>
                <div class="mb-3">
                    <label class="form-label">Date</label>
                    <input type="date" name="date" class="form-control">
                </div>

                <div class="mb-3">
                    <label class="form-label">Priority</label>
                    <input type="text" name="priority" class="form-control">
                </div>

                <div class="mb-3">
                    <label class="form-label">Description</label>
                    <input type="text" name="description" class="form-control">
                </div>


                <button class="btn btn-primary" type="submit">ADD TASK</button>

            </form>
        </div>
        <div class="col">

        </div>
        <div class="col">

        </div>
    </div>

</div>

</body>
</html>