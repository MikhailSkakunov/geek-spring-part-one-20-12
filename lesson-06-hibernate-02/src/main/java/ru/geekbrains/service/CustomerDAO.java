package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.entity.Customer;

import javax.persistence.EntityManager;

@Component
public class CustomerDAO {

    @Autowired
    public Service service;

    public Customer findById(Long id) {
        EntityManager em = service.getFactory().createEntityManager();
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, id);
            em.getTransaction().commit();
            em.close();
            System.out.println(customer);
            return customer;
        }
}
