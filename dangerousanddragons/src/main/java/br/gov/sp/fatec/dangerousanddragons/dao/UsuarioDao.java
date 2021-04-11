package br.gov.sp.fatec.dangerousanddragons.dao;

import br.gov.sp.fatec.dangerousanddragons.model.Usuario;

import java.util.List;

public interface UsuarioDao {

    Usuario cadastrarUsuario(String nomeUsuario, String senha, String nomeExibicao);

    Usuario buscarUsuario(Long idUsuario);

    List<Usuario> buscarUsuarioPorNome(String nome);

    Usuario salvarUsuario(Usuario usuario);

    Usuario commitUsuario(Usuario usuario);

    void removerUsuario(Long idUsuario);

    String getClearance(Long idUsuario);

    List<Usuario> todosUsuario();
}