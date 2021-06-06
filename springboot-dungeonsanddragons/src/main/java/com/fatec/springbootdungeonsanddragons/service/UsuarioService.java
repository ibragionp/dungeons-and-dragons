package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.springframework.stereotype.Service;
import java.util.List;


public interface UsuarioService {
    public RequestResult cadastrarUsuario(Usuario usuario);
    public RequestResult buscarUsuarioPorNome(String nome);
    public RequestResult buscarUsuarioPorId(Long id);
    public RequestResult editarUsuario(Long id, String nomeUsuario, String senha, String nomeExibicao);
    public RequestResult removerUsuario(Long id);
    public RequestResult listarUsuarios();
}
