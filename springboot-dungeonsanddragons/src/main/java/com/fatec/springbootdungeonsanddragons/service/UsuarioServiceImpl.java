package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.repository.UsuarioRepository;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public RequestResult cadastrarUsuario(Usuario usuario) {
        List<Usuario> usuariosExistentes = usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario());
        if (!(usuariosExistentes.isEmpty())){
            return new RequestResult().error("O nome de usuário já está cadastrado.");
        }
        usuarioRepository.save(usuario);
        return new RequestResult<>().success();
    }

    @Override
    public RequestResult buscarUsuarioPorNome(String nomeUsuario) {
        List<Usuario> usuariosExistentes = usuarioRepository.findByNomeUsuario(nomeUsuario);
        if (!(usuariosExistentes.isEmpty())){
            return new RequestResult<>(usuariosExistentes);
        }
        return new RequestResult().error("Usuário não encontrado.");
    }

    @Override
    public RequestResult buscarUsuarioPorId(Long id) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (!(usuarioExistente == null)){
            return new RequestResult<>(usuarioExistente);
        }
        return new RequestResult().error("Usuário não encontrado.");
    }

    @Override
    public RequestResult editarUsuario(Long id, String nomeUsuario, String senha, String nomeExibicao) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (!(usuarioExistente == null)){
            usuarioExistente.setNomeUsuario(nomeUsuario);
            usuarioExistente.setSenha(senha);
            usuarioExistente.setNomeExibicao(nomeExibicao);
            usuarioRepository.save(usuarioExistente);
            return new RequestResult().success();
        }
        return new RequestResult().error("Usuário não encontrado.");
    }

    @Override
    public RequestResult removerUsuario(Long id) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (!(usuarioExistente == null)){
            usuarioRepository.deleteById(id);
            return new RequestResult().success();
        }
        return new RequestResult().error("Usuário não encontrado.");
    }

    @Override
    public RequestResult listarUsuarios() {
        List<Usuario> usuariosExistentes = usuarioRepository.findAll();
        if (!(usuariosExistentes.isEmpty())){
            return new RequestResult<>(usuariosExistentes);
        }
        return new RequestResult().error("Não foram encontrados usuários.");
    }

}
