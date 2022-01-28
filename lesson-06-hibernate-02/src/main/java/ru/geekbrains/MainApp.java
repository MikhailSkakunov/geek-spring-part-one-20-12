package ru.geekbrains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.service.ApConfig;
import ru.geekbrains.service.CustomerDAO;
import ru.geekbrains.service.ProductDAO;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApConfig.class);

        ProductDAO productDAO = applicationContext.getBean(ProductDAO.class);
        productDAO.findAll();
        productDAO.findById(6L);

        CustomerDAO customerDAO = applicationContext.getBean(CustomerDAO.class);
        customerDAO.findById(1L);
   }
}
