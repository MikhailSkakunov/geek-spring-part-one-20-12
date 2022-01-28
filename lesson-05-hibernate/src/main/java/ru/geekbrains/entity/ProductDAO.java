package ru.geekbrains.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class ProductDAO {

    private EntityManagerFactory emFactory;

    public ProductDAO(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public List<Product> findAll() {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        List<Product> products = em.createNativeQuery("select * from products", Product.class)
                .getResultList();
        em.getTransaction().commit();
        em.close();
        System.out.println(products);
        return products;
    }

    public Product findById(long id) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.getTransaction().commit();
        em.close();
        System.out.println(product);
        return product;
    }

    public void saveOrUpdate(Product product) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        if (product.getId() == null)
        em.persist(product);
        else em.merge(product);
        em.getTransaction().commit();
        em.close();
        System.out.println(product);
    }

    public void delete(Long id) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Product p where p.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}