package br.gov.sp.fatec.dangerousanddragons.dao;

import br.gov.sp.fatec.dangerousanddragons.exception.ExceptionDao;
import br.gov.sp.fatec.dangerousanddragons.model.Grupo;
import br.gov.sp.fatec.dangerousanddragons.model.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

public class GrupoDaoJpa implements GrupoDao{
    private EntityManager entityManager;
    public GrupoDaoJpa(){
        this(PersistenceManager.getInstance().getEntityManager());
    }
    public GrupoDaoJpa(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Grupo commitGrupo(Grupo grupo) {
        try{
            entityManager.getTransaction().begin();
            if(grupo.getMestre() != null && grupo.getMestre().getId() == null){
                UsuarioDao usuarioBanco = new UsuarioDaoJpa(entityManager);
                usuarioBanco.commitUsuario(grupo.getMestre());
            }
            if(grupo.getId() == null){
                entityManager.persist(grupo);
            } else {
                entityManager.merge(grupo);
            }
            entityManager.getTransaction().commit();
            return grupo;
        }
        catch(PersistenceException pe){
            pe.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Ocorreu um erro ao salvar o grupo: ", pe);
        }
    }

    @Override
    public Grupo buscarGrupo(Long mestreId, String nomeGrupo) {
        String jpql = "SELECT g FROM Grupo g INNER JOIN g.mestre m where m.id = :mestreId and g.nomeGrupo = :nomeGrupo";
        TypedQuery<Grupo> query = (TypedQuery<Grupo>) entityManager.createQuery(jpql, Grupo.class);
        query.setParameter("mestreId", mestreId);
        query.setParameter("nomeGrupo", nomeGrupo);
        try{
            return query.getSingleResult();
        } catch (NoResultException e){
            return new Grupo();
        }
    }

    /*
    public List<Aluno> executeQuery(String nome, String email) {
        System.out.println("-- executing query ALUNO --");
        String queryText = "select a " +
                "from Aluno a " +
                "inner join a.orientador o where o.nomeUsuario = :nomeUsuario and o.email = :email";
        TypedQuery<Aluno> query = (TypedQuery<Aluno>) manager.createQuery(queryText, Aluno.class);
        query.setParameter("nomeUsuario", nome);
        query.setParameter("email", email);
        List<Aluno> resultado = query.getResultList();
        resultado.forEach(System.out::println);
        return resultado;
    }
    */

    @Override
    public void removerGrupo(Long mestreId, String nomeGrupo) {
        Grupo grupo = buscarGrupo(mestreId, nomeGrupo);
        if(grupo == null){
            throw new ExceptionDao("O grupo solicitado para ser removido não foi encontrado.");
        }
        entityManager.getTransaction().begin();
        entityManager.remove(grupo);
        entityManager.getTransaction().commit();
    }
}
