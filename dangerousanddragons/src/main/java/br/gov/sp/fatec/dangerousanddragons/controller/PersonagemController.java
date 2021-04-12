package br.gov.sp.fatec.dangerousanddragons.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.sp.fatec.dangerousanddragons.dao.PersonagemDao;
import br.gov.sp.fatec.dangerousanddragons.dao.PersonagemDaoJpa;
import br.gov.sp.fatec.dangerousanddragons.model.Personagem;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonagemController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idPersonagem = Long.valueOf(req.getParameter("idPersonagem"));
        if (idPersonagem == 0) {
            try{
                PersonagemDao personagemDao = new PersonagemDaoJpa();
                List<Personagem> personagens = personagemDao.todosPersonagem();
                ObjectMapper mapper = new ObjectMapper();
                String personagensJson = mapper.writeValueAsString(personagens);

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.setStatus(200);
                PrintWriter out = resp.getWriter();
                out.print(personagensJson);
                out.flush();
            } catch (NullPointerException npe) {
                resp.sendError(400, "Valor buscado inválido.");
                return;
            } catch (NoResultException nre) {
                resp.sendError(404, "Usuário não cadastrado.");
                return;
            }
        } else{
            try {
                PersonagemDao personagemDao = new PersonagemDaoJpa();
                Personagem personagem = personagemDao.buscarPersonagem(idPersonagem);
                ObjectMapper mapper = new ObjectMapper();
                String personagemJson = mapper.writeValueAsString(personagem);

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.setStatus(200);
                PrintWriter out = resp.getWriter();
                out.print(personagemJson);
                out.flush();
            } catch (NullPointerException npe) {
                resp.sendError(400, "Valor buscado inválido.");
                return;
            } catch (NoResultException nre) {
                resp.sendError(404, "Usuário não cadastrado.");
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperamos o corpo da requisição e transformamos o JSON em objeto
        ObjectMapper mapper = new ObjectMapper();
        Personagem personagem = mapper.readValue(req.getReader(), Personagem.class);

        // Salvamos no Banco de Dados
        PersonagemDao personagemDao = new PersonagemDaoJpa();
        personagemDao.commitPersonagem(personagem);

        // Retornamos o registro gerado
        String personagemJson = mapper.writeValueAsString(personagem);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // O código 201 requer que retornemos um header de Location
        resp.setStatus(201);
        String location = req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/personagem?idPersonagem="
                + personagem.getId();
        resp.setHeader("Location", location);
        PrintWriter out = resp.getWriter();
        out.print(personagemJson);
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recupera o parâmetro id (de usuario?nomeUsuario=<valor>)
        //String nomeUsuario = String.valueOf(req.getParameter("nomeUsuario"));
        Long idPersonagem = Long.valueOf(req.getParameter("idPersonagem"));

        // Busca usuario com o nome de usuario
        PersonagemDao personagemDao = new PersonagemDaoJpa();
        try{
            personagemDao.removerPersonagem(idPersonagem);
        } catch(Exception e){
            resp.sendError(404, "Usuario nao encontrado");
            return;
        }

        // Formatamos a resposta
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(200);
        PrintWriter out = resp.getWriter();
        out.print("");
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperamos o corpo da requisição e transformamos o JSON em objeto
        ObjectMapper mapper = new ObjectMapper();
        Personagem personagem = mapper.readValue(req.getReader(), Personagem.class);

        // Salvamos no Banco de Dados
        PersonagemDao personagemDao = new PersonagemDaoJpa();

        Long idPersonagem = Long.valueOf(req.getParameter("idPersonagem"));
        /*
        if(usuarioDao.buscarUsuario(nomeUsuario) != null){
            usuario.setId(usuarioDao.buscarUsuario(nomeUsuario).getId());
            usuarioDao.commitUsuario(usuario);
        } else {
            throw new RuntimeException("O usuário solicitado não foi encontrado.");
        }
        */

        try{
            personagem.setId(personagemDao.buscarPersonagem(idPersonagem).getId());
            personagemDao.commitPersonagem(personagem);
        } catch(Exception e){
            resp.sendError(404, "Usuario nao encontrado");
            return;
        }

        // Formatamos a resposta
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(200);
        PrintWriter out = resp.getWriter();
        out.print("");
        out.flush();
    }
}
