package br.gov.sp.fatec.dangerousanddragons.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    private static PersistenceManager instance;
    private PersistenceManager(){}

    protected EntityManagerFactory entityManagerFactory;

    public static PersistenceManager getInstance(){
        if(instance == null){
            instance = new PersistenceManager();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory(){
        if(entityManagerFactory == null){
            createEntityManagerFactory();
        }
        return entityManagerFactory;
    }

    public EntityManager getEntityManager(){
        if(entityManagerFactory == null){
            createEntityManagerFactory();
        }
        return entityManagerFactory.createEntityManager();
    }

    private void createEntityManagerFactory(){
        entityManagerFactory = Persistence.createEntityManagerFactory("dangerousanddragons");
    }
}