package br.gov.sp.fatec.dangerousanddragons;

import br.gov.sp.fatec.dangerousanddragons.dao.FeiticeiroDaoJpa;
import br.gov.sp.fatec.dangerousanddragons.dao.GrupoDaoJpa;
import br.gov.sp.fatec.dangerousanddragons.dao.LutadorDaoJpa;
import br.gov.sp.fatec.dangerousanddragons.dao.UsuarioDaoJpa;
import br.gov.sp.fatec.dangerousanddragons.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;

public class App {
    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("dangerousanddragons");
        EntityManager manager = factory.createEntityManager();

        // SEGMENTO DEDICADO A PARTE DE USUÁRIO
        // CREATE
        UsuarioDaoJpa usuarioBanco = new UsuarioDaoJpa(manager);
        Usuario usuario1 = usuarioBanco.cadastrarUsuario("usuario1", "senha", "Ana");
        Usuario usuario2 = usuarioBanco.cadastrarUsuario("usuario2", "senha", "Bernardo");
        Usuario usuario3 = usuarioBanco.cadastrarUsuario("usuario3", "senha", "Claudia");
        Usuario usuario4 = usuarioBanco.cadastrarUsuario("usuario4", "senha", "Daniel");
        Usuario usuario5 = usuarioBanco.cadastrarUsuario("usuario5", "senha", "Eliana");

        // READ
        System.out.println(usuarioBanco.buscarUsuario(usuario1.getId()).getNomeExibicao());

        // UPDATE
        Usuario usuario = new Usuario();
        usuario = usuarioBanco.buscarUsuario(usuario4.getId());
        usuario.setNomeExibicao("Danilo");
        usuarioBanco.commitUsuario(usuario);

        // DELETE
        usuarioBanco.removerUsuario(usuario5.getId());

        // SEGMENTO DEDICADO A PARTE DE PERSONAGENS
        // CREATE
        LutadorDaoJpa lutadorBanco = new LutadorDaoJpa(manager);
        FeiticeiroDaoJpa feiticeiroBanco = new FeiticeiroDaoJpa(manager);

        Feiticeiro feiticeiroAndrew = feiticeiroBanco.cadastrarFeiticeiro("Andrew", "Elfo", "Clérigo", usuarioBanco.buscarUsuario(usuario.getId()));
        Feiticeiro feiticeiroElidor = feiticeiroBanco.cadastrarFeiticeiro("Elidor", "Halfling", "Clérigo", usuarioBanco.buscarUsuario(usuario3.getId()));
        Feiticeiro feiticeiroAstrid = feiticeiroBanco.cadastrarFeiticeiro("Astrid", "Meio-Elfo", "Clérigo", usuarioBanco.buscarUsuario(usuario4.getId()));

        Lutador lutadorRufusCave = lutadorBanco.cadastrarLutador("Rufus Cave", "Humano", "Bárbaro", usuarioBanco.buscarUsuario(usuario3.getId()));

        // SEGMENTO DEDICADO A PARTE DO GRUPO
        // CREATE
        Grupo grupo = new Grupo();
        GrupoDaoJpa grupoBanco = new GrupoDaoJpa(manager);

        grupo.setIntegrantes(new HashSet<Personagem>());
        grupo.setMestre(usuarioBanco.buscarUsuario(usuario1.getId()));
        grupo.setNomeGrupo("Duque Cave");
        grupo.getIntegrantes().add(lutadorBanco.buscarLutador(lutadorRufusCave.getId()));
        grupoBanco.commitGrupo(grupo);

        grupo = new Grupo();
        grupo.setIntegrantes(new HashSet<Personagem>());
        grupo.setMestre(usuarioBanco.buscarUsuario(usuario1.getId()));
        grupo.setNomeGrupo("The A-Men");
        grupo.getIntegrantes().add(feiticeiroBanco.buscarFeiticeiro(feiticeiroAndrew.getId()));
        grupo.getIntegrantes().add(feiticeiroBanco.buscarFeiticeiro(feiticeiroElidor.getId()));
        grupo.getIntegrantes().add(feiticeiroBanco.buscarFeiticeiro(feiticeiroAstrid.getId()));
        grupoBanco.commitGrupo(grupo);

        System.out.print("The A-Men id: " + grupoBanco.buscarGrupo(10L, "The A-Men").getId());

        // SEGMENTO DEDICADO À INCLUSÃO DE ADMINISTRADORES
        Admin admin = new Admin();
        admin.setNomeUsuario("admin1");
        admin.setSenha("adm1n");
        admin.setNomeExibicao("Administradora Amanda");
        admin.setClassificacao(5);

        manager.getTransaction().begin();
        if(usuario.getId() == null){
            manager.persist(admin);
        } else {
            manager.merge(admin);
        }
        manager.getTransaction().commit();


        admin.setNomeUsuario("admin2");
        admin.setSenha("adm1n");
        admin.setNomeExibicao("Administrador Bruno");
        admin.setClassificacao(5);

        manager.getTransaction().begin();
        if(usuario.getId() == null){
            manager.persist(admin);
        } else {
            manager.merge(admin);
        }
        manager.getTransaction().commit();

    }
}
