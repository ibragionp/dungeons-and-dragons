package br.gov.sp.fatec.dangerousanddragons.dao;

import br.gov.sp.fatec.dangerousanddragons.exception.ExceptionDao;
import br.gov.sp.fatec.dangerousanddragons.model.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class FeiticeiroDaoJpa implements FeiticeiroDao{
    private EntityManager entityManager;
    public FeiticeiroDaoJpa(){
        this(PersistenceManager.getInstance().getEntityManager());
    }
    public FeiticeiroDaoJpa(EntityManager em){
        this.entityManager = em;
    }

    @Override
    public Feiticeiro cadastrarFeiticeiro(String nome, String raca, String classe, Usuario proprietario) {
        Feiticeiro feiticeiro = new Feiticeiro();
        feiticeiro.setNome(nome);
        feiticeiro.setRaca(raca);
        feiticeiro.setClasse(classe);
        feiticeiro.setProprietario(proprietario);
        feiticeiro.setMagiasConhecidas(3);
        feiticeiro.setModificadorHabilidade(5);
        return commitFeiticeiro(feiticeiro);
    }

    @Override
    public List<Feiticeiro> buscarFeiticeiroPorNome(String nomeFeiticeiro) {
        String jpql = "select u from Feiticeiro u where u.nomeFeiticeiro = :nomeFeiticeiro";
        TypedQuery<Feiticeiro> query = entityManager.createQuery(jpql, Feiticeiro.class);
        query.setParameter("nomeFeiticeiro", nomeFeiticeiro);
        try {
            return query.getResultList();
        } catch (NoResultException e){
            return new ArrayList<Feiticeiro>();
        }
    }

    @Override
    public Feiticeiro buscarFeiticeiro(Long idFeiticeiro) {
        String jpql = "select l from Feiticeiro l where l.id = :idFeiticeiro";
        TypedQuery<Feiticeiro> query = entityManager.createQuery(jpql, Feiticeiro.class);
        query.setParameter("idFeiticeiro", idFeiticeiro);
        try{
            return query.getSingleResult();
        } catch (NoResultException e){
            return new Feiticeiro();
        }
    }

    @Override
    public Feiticeiro commitFeiticeiro(Feiticeiro feiticeiro){
        try{
            entityManager.getTransaction().begin();
            salvarFeiticeiro(feiticeiro);
            entityManager.getTransaction().commit();
            return feiticeiro;
        }
        catch(PersistenceException pe){
            pe.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Ocorreu um erro ao salvar o feiticeiro: ", pe);
        }
    }

    @Override
    public Feiticeiro salvarFeiticeiro(Feiticeiro feiticeiro){
        if(feiticeiro.getId() == null){
            entityManager.persist(feiticeiro);
        } else {
            entityManager.merge(feiticeiro);
        }   return feiticeiro;
    }


    @Override
    public void removerFeiticeiro(Long idFeiticeiro) {
        Feiticeiro feiticeiro = buscarFeiticeiro(idFeiticeiro);
        if(feiticeiro == null){
            throw new ExceptionDao("O personagem solicitado para ser removido não foi encontrado.");
        }
        entityManager.getTransaction().begin();
        entityManager.remove(feiticeiro);
        entityManager.getTransaction().commit();
    }
}
