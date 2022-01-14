package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws SecurityException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();
        String id = req.getParameter("id");
        if (req.getParameter("id") != null) {
            wr.println(id);
            wr.println("<p>Product information - " + productRepository.findById(Long.parseLong(id)).getName() + "</p>");
            wr.println("<h3><a href=product>Главная</a><h3>");

            wr.println("<table>");
            wr.println("<tr>");
            wr.println("<th>Id</th>");
            wr.println("<th>Name</th>");
            wr.println("</tr>");
            wr.println("<tr>");
            wr.println("<td>" + productRepository.findById(Long.parseLong(id)).getId() + "</td>");
            wr.println("<td>" + productRepository.findById(Long.parseLong(id)).getName() + "</td>");
            wr.println("/<tr>");
            wr.println("</table>");

            // TODO
        } else if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {
            wr.println("<table>");
            wr.println("<tr>");
            wr.println("<th>Id</th>");
            wr.println("<th>Name</th>");
            wr.println("</tr>");

            for (Product product : productRepository.findAll()) {
                wr.println("<tr>");
                wr.println("<td>" + product.getId() + "</td>");
                wr.println("<td><a href=product?id=" + product.getId() + ">" +  product.getName() + "</a></td>");
                // TODO <a href='product?id=12'></a>
                wr.println("</tr>");
            }
            wr.println("</table>");
        }
    }
}
