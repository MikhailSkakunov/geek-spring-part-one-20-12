package ru.geekbrains.service;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.geekbrains.init.InitDataBase;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@Component
public class Service {

    private EntityManagerFactory emFactory;

    @PostConstruct
    public void init() {
        InitDataBase.forcePrepareData();

        emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager em = emFactory.createEntityManager();
    }

    public EntityManagerFactory getFactory() {
        return emFactory;
    }
}



//        EntityManager em = emFactory.createEntityManager();

// INSERT
//        em.getTransaction().begin();
//        em.persist(new User(null, "user1", "pass1"));
//        em.getTransaction().commit();

//SELECT

//        System.out.println("User:");
//        User user = em.find(User.class, 1L);
//        System.out.println(user);

//SELECT 2
//        System.out.println("Users:");
//        List<User> users = em.createQuery("select u from User u where u.username = :username", User.class)
//                .setParameter("username", "user1")
//                .getResultList();
//        System.out.println(users);

//        users = em.createNativeQuery("select * from users", User.class)
//                .getResultList();
//        System.out.println(users);

//UPDATE 1
//        User user = em.find(User.class, 3L);
//        em.getTransaction().begin();
//        user.setPassword("pass123");
//        em.getTransaction().commit();

//UPDATE 2
//        User user = new User(1L, "user1", "password1");
//        em.getTransaction().begin();
//        em.merge(user);
//        em.getTransaction().commit();
//        System.out.println(user);

//UPDATE 3
//        em.getTransaction().begin();
//        em.createQuery("update User set username = :username, password = :password where id = :id")
//                        .setParameter("username","user1")
//                        .setParameter("password","pass1")
//                        .setParameter("id", 3L)
//                        .executeUpdate();
//        em.getTransaction().commit();

//DELETE 1
//        em.getTransaction().begin();
//        User user = em.find(User.class, 3L);
//        em.remove(user);
//        em.getTransaction().commit();

//DELETE 2
//        em.getTransaction().begin();
//        em.createQuery("delete from User  where  id = :id")
//                .setParameter("id", 2L)
//                .executeUpdate();

//        em.getTransaction().commit();

//        em.close();