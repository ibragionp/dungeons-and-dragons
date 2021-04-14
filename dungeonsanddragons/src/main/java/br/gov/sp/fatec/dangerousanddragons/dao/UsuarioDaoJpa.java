package br.gov.sp.fatec.dangerousanddragons.dao;

import br.gov.sp.fatec.dangerousanddragons.exception.ExceptionDao;
import br.gov.sp.fatec.dangerousanddragons.model.Admin;
import br.gov.sp.fatec.dangerousanddragons.model.PersistenceManager;
import br.gov.sp.fatec.dangerousanddragons.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsuarioDaoJpa implements UsuarioDao {

    private EntityManager entityManager;

    public UsuarioDaoJpa(){
        this(PersistenceManager.getInstance().getEntityManager());
    }

    public UsuarioDaoJpa(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Usuario cadastrarUsuario(String nomeUsuario, String senha, String nomeExibicao) {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setSenha(senha);
        usuario.setNomeExibicao(nomeExibicao);
        return commitUsuario(usuario);
    }

    @Override
    public Usuario buscarUsuario(Long idUsuario) {
        String jpql = "select u from Usuario u where u.id = :id";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("id", idUsuario);
        return query.getSingleResult();
    }

    @Override
    public List<Usuario> buscarUsuarioPorNome(String nomeUsuario) {
        String jpql = "select u from Usuario u where u.nomeUsuario = :nomeUsuario";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }

    @Override
    public Usuario commitUsuario(Usuario usuario){
        try{
            entityManager.getTransaction().begin();
            salvarUsuario(usuario);
            entityManager.getTransaction().commit();
            return usuario;
        }
        catch(PersistenceException pe){
            pe.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new ExceptionDao(String.format("Ocorreu um erro ao salvar o usuário: %",
                    usuario.toString()));
        }
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario){
        if(usuario.getId() == null){
            entityManager.persist(usuario);
        } else {
            entityManager.merge(usuario);
        }   return usuario;
    }

    @Override
    public void removerUsuario(Long idUsuario) {
        Usuario usuario = buscarUsuario(idUsuario);
        if(usuario == null){
            throw new ExceptionDao("O usuário solicitado para ser removido não foi encontrado.");
        }
        entityManager.getTransaction().begin();
        entityManager.remove(usuario);
        entityManager.getTransaction().commit();
    }

    @Override
    public String getClearance(Long idUsuario) {
        Usuario usuario = buscarUsuario(idUsuario);
        String clearance = new String();

        if(usuario instanceof Admin){
            clearance = "Administrador";
        } else {
            clearance = "Usuario";
        }
        return clearance;
    }

    @Override
    public List<Usuario> todosUsuario() {
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }
}
