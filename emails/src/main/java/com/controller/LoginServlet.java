package com.controller;

import com.entity.Employee;
import com.service.loginService;
import com.service.loginServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("uname");
        String pwd = request.getParameter("upwd");
        String savepwd = request.getParameter("savepwd");
        loginService service = new loginServiceImpl();
        Employee emp = new Employee();
        emp.setLoginname(name);
        emp.setPassword(pwd);
        Employee current = service.validateLogin(emp);
        if (current != null) {
            request.getSession().setAttribute("currentEmp", current);
            response.sendRedirect("worker.jsp");
        } else {
            //登录失败返回登录界面并给出提示
            response.sendRedirect("email.jsp?loginfaild=error");
        }
    }
}
