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

        <div class="mb-3">
            <label class="form-label">Name :</label>
            <b><%=task.getName()%>"</b>
        </div>
        <div class="mb-3">
            <label class="form-label">Date:</label>
            <b><%=task.getDate()%>" </b>
        </div>
        <div class="mb-3">
            <label class="form-label">Priority:</label>
            <b><%=task.getPriority()%>" </b>
        </div>
        <div class="mb-3">
            <label class="form-label">Description:</label>
            <b><%=task.getDescription()%>" </b>
        </div>


        <button class="btn btn-primary btn-lg"><a class="nav-link active" aria-current="page" style="color: aliceblue"
                                                  href="/edit?id=<%=task.getId()%>">EDIT</a></button>

        </form>
    </div>


</div>

</body>
</html>
