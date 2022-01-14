package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;
import ru.geekbrains.persist.ProductRepositoryImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        ProductRepository productRepository = new ProductRepositoryImpl();

        productRepository.save(new Product(1L, "product 1"));
        productRepository.save(new Product(2L, "product 2"));
        productRepository.save(new Product(3L, "product 3"));
        sc.setAttribute("productRepository", productRepository);
    }
}
