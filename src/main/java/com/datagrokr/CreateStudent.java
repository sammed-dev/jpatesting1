package com.datagrokr;

import com.datagrokr.model.Student;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;
import javax.transaction.Transactional;

public class CreateStudent {

    public static void main(String[] args) {

//        PersistenceProvider provider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        Student student = new Student();
        student.setFirstName("sammed");
        student.setLastName("sankonatti");
        entityManager.persist(student);
        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
