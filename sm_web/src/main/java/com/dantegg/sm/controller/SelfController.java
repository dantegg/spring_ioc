package com.dantegg.sm.controller;

import com.dantegg.sm.entity.Staff;
import com.dantegg.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("selfController")
public class SelfController {

    @Autowired
    private SelfService selfService;

    // /toLogin.do
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    // /login.do
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Staff staff = selfService.login(account, password);
        if(staff == null) {
            response.sendRedirect("toLogin.do");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("USER", staff);
            response.sendRedirect("main.do");
        }
    }

    // main.do
    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // logout.do
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("USER", null);
        response.sendRedirect("toLogin.do");
    }

    // self/info.do
    public void info(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("../info.jsp").forward(request, response);
    }

    // self/changePassword.do
    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        HttpSession session = request.getSession();
        Staff staff = (Staff)session.getAttribute("USER");
        if(!staff.getPassword().equals(password)) {
            response.sendRedirect("toChangePassword.do");
        } else {
            selfService.changePassword(staff.getId(), password1);
            // response.sendRedirect("../logout.do");
            response.getWriter().println("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");
        }
    }

    // self/toChangePassword.do
    public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("../change_password.jsp").forward(request, response);
    }

}
