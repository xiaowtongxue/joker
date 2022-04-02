package com.controller;

import com.entity.Employee;
import com.entity.InBox;
import com.service.allMailService;
import com.service.allMailServiceImpl;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/allMailServlet")
public class AllMailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mess = request.getParameter("id");

        allMailService service = new allMailServiceImpl();

        List<InBox> mailList = service.queryAllMail(mess);
        List<Employee> empList = service.queryAllEmp();
        request.getSession().setAttribute("AllMail", mailList);
        request.getSession().setAttribute("AllEmp",empList);
        request.getRequestDispatcher("allMail.jsp").forward(request, response);
    }
}
