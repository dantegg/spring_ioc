package com.dantegg.sm.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("testController")
public class TestController {

    // /test/show.do /test.jsp
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("NAME", "dante");
        request.getRequestDispatcher("../test.jsp").forward(request, response);
    }

}
