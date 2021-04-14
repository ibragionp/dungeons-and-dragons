package br.gov.sp.fatec.dangerousanddragons.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.sp.fatec.dangerousanddragons.dao.UsuarioDao;
import br.gov.sp.fatec.dangerousanddragons.dao.UsuarioDaoJpa;
import br.gov.sp.fatec.dangerousanddragons.model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idUsuario = Long.valueOf(req.getParameter("idUsuario"));
        if (idUsuario == 0) {
            try{
                UsuarioDao usuarioDao = new UsuarioDaoJpa();
                List<Usuario> usuarios = usuarioDao.todosUsuario();
                ObjectMapper mapper = new ObjectMapper();
                String usuariosJson = mapper.writeValueAsString(usuarios);

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.setStatus(200);
                PrintWriter out = resp.getWriter();
                out.print(usuariosJson);
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
                UsuarioDao usuarioDao = new UsuarioDaoJpa();
                Usuario usuario = usuarioDao.buscarUsuario(idUsuario);
                ObjectMapper mapper = new ObjectMapper();
                String usuarioJson = mapper.writeValueAsString(usuario);

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.setStatus(200);
                PrintWriter out = resp.getWriter();
                out.print(usuarioJson);
                out.flush();
            } catch (NullPointerException npe) {
                resp.sendError(400, "Valor buscado inválido");
                return;
            } catch (NoResultException nre) {
                resp.sendError(404, "Usuário não cadastrado");
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperamos o corpo da requisição e transformamos o JSON em objeto
        ObjectMapper mapper = new ObjectMapper();
        Usuario usuario = mapper.readValue(req.getReader(), Usuario.class);

        // Salvamos no Banco de Dados
        UsuarioDao usuarioDao = new UsuarioDaoJpa();
        usuarioDao.commitUsuario(usuario);

        // Retornamos o registro gerado
        String usuarioJson = mapper.writeValueAsString(usuario);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // O código 201 requer que retornemos um header de Location
        resp.setStatus(201);
        String location = req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/usuario?idUsuario="
                + usuario.getId();
        resp.setHeader("Location", location);
        PrintWriter out = resp.getWriter();
        out.print(usuarioJson);
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recupera o parâmetro id (de usuario?nomeUsuario=<valor>)
        //String nomeUsuario = String.valueOf(req.getParameter("nomeUsuario"));
        Long idUsuario = Long.valueOf(req.getParameter("idUsuario"));

        // Busca usuario com o nome de usuario
        UsuarioDao usuarioDao = new UsuarioDaoJpa();
        try{
            usuarioDao.removerUsuario(idUsuario);
        } catch(Exception e){
            resp.sendError(404, "Usuário não encontrado.");
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
        Usuario usuario = mapper.readValue(req.getReader(), Usuario.class);

        // Salvamos no Banco de Dados
        UsuarioDao usuarioDao = new UsuarioDaoJpa();

        Long idUsuario = Long.valueOf(req.getParameter("idUsuario"));
        /*
        if(usuarioDao.buscarUsuario(nomeUsuario) != null){
            usuario.setId(usuarioDao.buscarUsuario(nomeUsuario).getId());
            usuarioDao.commitUsuario(usuario);
        } else {
            throw new RuntimeException("O usuário solicitado não foi encontrado.");
        }
        */

        try{
            usuario.setId(usuarioDao.buscarUsuario(idUsuario).getId());
            usuarioDao.commitUsuario(usuario);
        } catch(Exception e){
            resp.sendError(404, "Usuário não encontrado.");
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