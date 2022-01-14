<%@ page import="com.example.demo2.DB.Tasks" %>
<html>
<head>
    <title>Teask.com</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%
    Tasks task = (Tasks) request.getAttribute("task");
%>
<div class="container">
    <%@include file="navbar.jsp" %>

    <div style="margin: 20px;">
        <form method="post" action="/edit">
            <div class="mb-3">
                <label class="form-label">ID:</label>
                <input type="text" class="form-control" name="id" value="<%=task.getId()%>">
            </div>
            <div class="mb-3">
                <label class="form-label">Name:</label>
                <input type="text" name="name" class="form-control" value="<%=task.getName()%>">
            </div>
            <div class="mb-3">
                <label class="form-label">Date:</label>
                <input type="date" name="date" class="form-control" value="<%=task.getDate()%>">
            </div>
            <div class="mb-3">
                <label class="form-label">Priority</label>
                <input type="text" name="priority" class="form-control" value="<%=task.getPriority()%>">
            </div>
            <div class="mb-3">
                <label class="form-label">Description:</label>
                <input type="text" name="description" class="form-control" value="<%=task.getDescription()%>">
            </div>


            <button class="btn btn-primary btn-lg" type="submit">SAVE TASK</button>
            <button type="button" class="btn btn-danger  btn-lg" data-bs-toggle="modal" data-bs-target="#exampleModal">
                DELETE TASK
            </button>

        </form>


        <!-- Button trigger modal -->


        <!-- Modal -->

        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="/delete" method="post">
                        <input type="hidden" class="form-control" name="id" value="<%=task.getId()%>">
                        <div class="modal-header">

                            <h5 class="modal-title" id="exampleModalLabel">Confirm delete</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Are you sure?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                            <button class="btn btn-danger">Yes</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </div>

</body>
</html>

