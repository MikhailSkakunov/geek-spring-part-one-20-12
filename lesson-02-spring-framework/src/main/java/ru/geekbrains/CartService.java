package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CartService {

    private final ProductRepository productRepository;
    private final Map<Product, Integer> productMap;

    @Autowired
    public CartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.productMap = new HashMap<>();
    }

    public List<Product> getProductAll() {
        return new ArrayList<>(productMap.keySet());
    }

    public void saveCart(long id, int count) {
        if (productRepository.findById(id) != null)
            productMap.merge(productRepository.findById(id), count, Integer::sum);
        else if (productRepository.findById(id) == null)
            throw new IllegalArgumentException("Product is not exist");
    }

    public void delete(long id, int count) {
        if (productMap.get(productRepository.findById(id)) <= count)
            productMap.remove(productRepository.findById(id));
        else productMap.merge(productRepository.findById(id), -count, Integer::sum);

    }
}

