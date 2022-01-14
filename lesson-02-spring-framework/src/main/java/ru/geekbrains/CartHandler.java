package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class CartHandler {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Scanner scanner = new Scanner(System.in);
        CartService cart = null;

        while (true) {
            System.out.println("Please enter command: ");
            String command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "NEW" :
                    cart = context.getBean(CartService.class);
                    System.out.println("Cart created!");
                    break;
                case "ADD PRODUCT" :
                    if (cart == null) {
                        System.out.println("Please create a Cart!");
                        break;
                    }
                    System.out.println("Please inter ID: ");
                    long id = scanner.nextLong();
                    System.out.println("Please inter COUNT: ");
                    int count = scanner.nextInt();
                    cart.saveCart(id, count); break;
                case "DISPLAY" :
                    if (cart == null) {
                        System.out.println("Please create a Cart!");
                        break;
                    }
                    cart.getProductAll().forEach(System.out::println);
                    break;
                case "EXIT" :
                    return;
            }
        }
    }
}
