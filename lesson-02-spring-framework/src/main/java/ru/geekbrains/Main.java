package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.persist.Product;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        ProductService productService = context.getBean("productService", ProductService.class);
        CartService cartService = context.getBean("cartService", CartService.class);

//        System.out.println("Product count = " + productService.count());
        System.out.println("CartService = " + cartService.getProductAll());
    }
}
