package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @GetMapping("/{id}")
    public String form(Model model, @PathVariable("id") long id) {
        model.addAttribute("product", productRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Product not found")));
        return "product_form";
    }

    @PostMapping
    public String saveProduct(Product product) {
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("/new")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundExceptionHandler(NotFoundException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "not_found";
    }


}
