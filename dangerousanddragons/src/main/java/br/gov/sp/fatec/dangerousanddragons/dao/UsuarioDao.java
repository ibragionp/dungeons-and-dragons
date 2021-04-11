package br.gov.sp.fatec.dangerousanddragons.dao;

import br.gov.sp.fatec.dangerousanddragons.model.Usuario;

import java.util.List;

public interface UsuarioDao {
    public Usuario cadastrarUsuario(String nomeUsuario, String senha, String nomeExibicao);

    public Usuario buscarUsuario(String nomeUsuario);

    public Usuario salvarUsuario(Usuario usuario);

    public Usuario commitUsuario(Usuario usuario);

    public void removerUsuario(String nomeUsuario);

    public String getClearance(String nomeUsuario);

    public List<Usuario> todosUsuario();
}