package com.example.pw2.controller;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    //private static final long serialVersionUID = 1L;
	private String message;

    public void init() {
        message = "Il commit/pull ha funzionato nuovamenteTTTTTTTT888888!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "ciao493"+ "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}