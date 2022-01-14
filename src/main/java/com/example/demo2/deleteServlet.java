package com.example.demo2;

import com.example.demo2.DB.DBManager;
import com.example.demo2.DB.Tasks;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( value = "/delete")
public class deleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id= Long.parseLong(request.getParameter("id"));

        Tasks task=DBManager.getTask(id);


        if (DBManager.deleteTask(task)){
            response.sendRedirect("/");
        }else {
            response.sendRedirect("/edit?id="+task.getId());
        }

    }
}
