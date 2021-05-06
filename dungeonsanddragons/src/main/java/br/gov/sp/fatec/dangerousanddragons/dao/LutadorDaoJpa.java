package br.gov.sp.fatec.dangerousanddragons.dao;

import br.gov.sp.fatec.dangerousanddragons.exception.ExceptionDao;
import br.gov.sp.fatec.dangerousanddragons.model.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class LutadorDaoJpa implements LutadorDao{
    private EntityManager entityManager;
    public LutadorDaoJpa(){
        this(PersistenceManager.getInstance().getEntityManager());
    }
    public LutadorDaoJpa(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Lutador cadastrarLutador(String nome, String raca, String classe, Usuario proprietario) {
        Lutador lutador = new Lutador();
        lutador.setNome(nome);
        lutador.setRaca(raca);
        lutador.setClasse(classe);
        lutador.setProprietario(proprietario);
        lutador.setdadosSuperioridade(3);
        return commitLutador(lutador);
    }

    @Override
    public List<Lutador> buscarLutadorPorNome(String nomeLutador) {
        String jpql = "select u from Lutador u where u.nomeLutador = :nomeLutador";
        TypedQuery<Lutador> query = entityManager.createQuery(jpql, Lutador.class);
        query.setParameter("nomeLutador", nomeLutador);
        try {
            return query.getResultList();
        } catch (NoResultException e){
            return new ArrayList<Lutador>();
        }
    }

    @Override
    public Lutador buscarLutador(Long idLutador) {
        String jpql = "select l from Lutador l where l.id = :idLutador";
        TypedQuery<Lutador> query = entityManager.createQuery(jpql, Lutador.class);
        query.setParameter("idLutador", idLutador);
        try{
            return query.getSingleResult();
        } catch (NoResultException e){
            return new Lutador();
        }
    }

    @Override
    public Lutador commitLutador(Lutador lutador){
        try{
            entityManager.getTransaction().begin();
            salvarLutador(lutador);
            entityManager.getTransaction().commit();
            return lutador;
        }
        catch(PersistenceException pe){
            pe.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Ocorreu um erro ao salvar o lutador: ", pe);
        }
    }

    @Override
    public Lutador salvarLutador(Lutador lutador){
        if(lutador.getId() == null){
            entityManager.persist(lutador);
        } else {
            entityManager.merge(lutador);
        }   return lutador;
    }


    @Override
    public void removerLutador(Long idLutador) {
        Lutador lutador = buscarLutador(idLutador);
        if(lutador == null){
            throw new ExceptionDao("O personagem solicitado para ser removido não foi encontrado.");
        }
        entityManager.getTransaction().begin();
        entityManager.remove(lutador);
        entityManager.getTransaction().commit();
    }
}
