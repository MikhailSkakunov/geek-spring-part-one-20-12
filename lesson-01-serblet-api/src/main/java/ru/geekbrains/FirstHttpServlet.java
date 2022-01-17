package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/first_http_servlet/*")
public class FirstHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Привет от HTTP Сервлета</h1>");
        resp.getWriter().println("<p>servletContext: " + req.getServletContext() + "</p>");
        resp.getWriter().println("<p>servletPath: " + req.getServletPath() + "</p>");
        resp.getWriter().println("<p>pathInfo: " + req.getPathInfo() + "<p>");
        resp.getWriter().println("<p>" + req.getQueryString() + "</p>");
        resp.getWriter().println("<p>" + req.getParameter("param 1") + "</p>");
        resp.getWriter().println("<p>" + req.getParameter("param 2") + "</p>");
    }
}
