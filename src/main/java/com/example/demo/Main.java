package com.example.demo;

import entity.LearnEntity;
import jakarta.persistence.*;

//import jakarta.*;
public class Main {
    public static void main(String[] args) {
        //System.out.println("hdjfj");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            LearnEntity learnEntity = new LearnEntity("ariel","dobkin","ar@gmail.com");
            entityManager.persist(learnEntity);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}