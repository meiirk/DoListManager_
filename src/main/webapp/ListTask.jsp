
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo2.DB.Tasks" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>Task manager.com</title>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>



    <%
        ArrayList<Tasks> tasks= (ArrayList<Tasks>) request.getAttribute("task");
    %>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Date</th>
            <th scope="col">Priority</th>
            <th scope="col">Description</th>
            <th scope="col">Details</th>
            <th scope="col">Mark</th>
        </tr>
        </thead>

        <%

            for (Tasks s:tasks) {

        %>
        <tbody>
        <tr>
            <th scope="row"><%=s.getId()%></th>
            <td><%=s.getName()%></td>
            <td><%=s.getDate()%></td>
            <td><%=s.getPriority()%></td>
            <td><%=s.getDescription()%></td>
            <td> <button  class="btn btn-primary">  <a class="nav-link active" aria-current="page" style="color: aliceblue" href="/details?id=<%=s.getId()%>" > Details</a> </button>
            </td>
            <td>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                    <label class="form-check-label" for="flexCheckDefault">
                        Done
                    </label>
                </div>
            </td>
        </tr>

            <%
    }
%>
    </table
</div>
</body>
</html>
