package com.example.demo2;

import com.example.demo2.DB.DBManager;
import com.example.demo2.DB.Tasks;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/edit")
public class editServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = 0L;
        try {
            id = Long.parseLong(request.getParameter("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Tasks task = DBManager.getTask(id);

        if (task != null) {
            request.setAttribute("task", task);
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String priority = request.getParameter("priority");
        String description = request.getParameter("description");

        Tasks task = DBManager.getTask(id);

        task.setName(name);
        task.setDate(date);
        task.setPriority(priority);
        task.setDescription(description);


        if (DBManager.editTask(task)) {
            response.sendRedirect("/edit?id=" + task.getId());
        } else {
            response.sendRedirect("/");
        }
    }
}
