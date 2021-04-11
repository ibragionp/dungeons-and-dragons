package br.gov.sp.fatec.dangerousanddragons.dao;

import br.gov.sp.fatec.dangerousanddragons.exception.ExceptionDao;
import br.gov.sp.fatec.dangerousanddragons.model.PersistenceManager;
import br.gov.sp.fatec.dangerousanddragons.model.Personagem;
import br.gov.sp.fatec.dangerousanddragons.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonagemDaoJpa implements PersonagemDao {

    private EntityManager entityManager;

    public PersonagemDaoJpa(){
        this(PersistenceManager.getInstance().getEntityManager());
    }

    public PersonagemDaoJpa(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Personagem cadastrarPersonagem(String nome, String raca, String classe,
                                          Usuario usuarioProprietario) {
        Personagem personagem = new Personagem();
        personagem.setProprietario(usuarioProprietario);
        personagem.setNome(nome);
        personagem.setRaca(raca);
        personagem.setClasse(classe);
        return commitPersonagem(personagem);
    }

    @Override
    public List<Personagem> buscarPersonagemPorNome(String nomePersonagem) {
        String jpql = "select u from Personagem u where u.nomePersonagem = :nomePersonagem";
        TypedQuery<Personagem> query = entityManager.createQuery(jpql, Personagem.class);
        return query.getResultList();
    }

    @Override
    public Personagem buscarPersonagem(Long idPersonagem) {
        String jpql = "select u from Personagem u where u.idPersonagem = :idPersonagem";
        TypedQuery<Personagem> query = entityManager.createQuery(jpql, Personagem.class);
        query.setParameter("idPersonagem", idPersonagem);
        return query.getSingleResult();
    }

    @Override
    public Personagem commitPersonagem(Personagem personagem){
        try{
            entityManager.getTransaction().begin();
            salvarPersonagem(personagem);
            entityManager.getTransaction().commit();
            return personagem;
        }
        catch(PersistenceException pe){
            pe.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new ExceptionDao(String.format("Ocorreu um erro ao salvar o personagem: %s",
                    personagem.toString()));
        }
    }

    @Override
    public Personagem salvarPersonagem(Personagem personagem){
        if(personagem.getId() == null){
            entityManager.persist(personagem);
        } else {
            entityManager.merge(personagem);
        }   return personagem;
    }

    @Override
    public void removerPersonagem(Long idPersonagem) {
        Personagem personagem = buscarPersonagem(idPersonagem);
        if(personagem == null){
            throw new ExceptionDao("O personagem solicitado para ser removido não foi encontrado.");
        }
        entityManager.getTransaction().begin();
        entityManager.remove(personagem);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Personagem> todosPersonagem() {
        String jpql = "select u from Personagem u";
        TypedQuery<Personagem> query = entityManager.createQuery(jpql, Personagem.class);
        return query.getResultList();
    }
}
