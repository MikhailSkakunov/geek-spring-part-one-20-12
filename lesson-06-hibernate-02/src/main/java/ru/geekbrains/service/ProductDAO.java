package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class ProductDAO {

    @Autowired
    public Service service;

    public List<Product> findAll() {
        EntityManager em = service.getFactory().createEntityManager();
        em.getTransaction().begin();
        List<Product> products = em.createNativeQuery("select * from products", Product.class)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        System.out.println(products);
        return products;
    }

    public Product findById(long id) {
        EntityManager em = service.getFactory().createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.getTransaction().commit();
        em.close();
        System.out.println(product);
        return product;
    }

    public void saveOrUpdate(Product product) {
        EntityManager em = service.getFactory().createEntityManager();
        em.getTransaction().begin();
        if (product.getId() == null)
        em.persist(product);
        else em.merge(product);
        em.getTransaction().commit();
        em.close();
        System.out.println(product);
    }

    public void delete(Long id) {
        EntityManager em = service.getFactory().createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Product p where p.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}