package com.example.demo2;

import com.example.demo2.DB.DBManager;
import com.example.demo2.DB.Tasks;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/add")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String priority = request.getParameter("priority");
        String description = request.getParameter("description");

        DBManager.addTask(new Tasks(null, name, date, priority, description));
        response.sendRedirect("/add");
    }
}
