package ru.geekbrains.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Customer customer;

    @Column
    private BigDecimal price;

    @Column
    private int number;

    public Item(Long id, Product product, Customer customer, BigDecimal price, int number) {
        this.id = id;
        this.product = product;
        this.customer = customer;
        this.price = price;
        this.number = number;
    }

    public Product getProducts() {
        return product;
    }

    public void setProducts(List<Product> products) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item() {
    }
}
