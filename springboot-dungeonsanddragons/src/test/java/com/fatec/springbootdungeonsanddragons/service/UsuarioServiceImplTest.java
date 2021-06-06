package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.repository.UsuarioRepository;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {

    @InjectMocks
    UsuarioServiceImpl usuarioServiceImpl;

    @Mock
    UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateUsuarioWithSuccess(){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");
        List<Usuario> usuariosEncontrados  = new ArrayList<>();

        when(usuarioRepository.findByNomeUsuario(any(String.class))).thenReturn(usuariosEncontrados);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        RequestResult usuarioCadastrado = usuarioServiceImpl.cadastrarUsuario(usuario);

        Assertions.assertEquals(1, usuarioCadastrado.getStatusCode());
    }

    @Test
    public void shouldNotCreateUsuarioWithSuccess(){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        List<Usuario> usuariosEncontrados  = new ArrayList<>();
        usuariosEncontrados.add(usuario);

        when(usuarioRepository.findByNomeUsuario(any(String.class))).thenReturn(usuariosEncontrados);

        RequestResult usuarioCadastrado = usuarioServiceImpl.cadastrarUsuario(usuario);

        Assertions.assertEquals(0, usuarioCadastrado.getStatusCode());
    }

    @Test
    public void shouldSearchUsuarioByName(){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");
        List<Usuario> usuariosEncontrados  = new ArrayList<>();
        usuariosEncontrados.add(usuario);

        when(usuarioRepository.findByNomeUsuario(any(String.class))).thenReturn(usuariosEncontrados);

        RequestResult usuarioEncontrado = usuarioServiceImpl.buscarUsuarioPorNome(usuario.getNomeUsuario());

        Assertions.assertEquals(1, usuarioEncontrado.getStatusCode());
    }

    @Test
    public void shouldNotSearchUsuarioByName(){
        List<Usuario> usuariosEncontrados  = new ArrayList<>();

        when(usuarioRepository.findByNomeUsuario(any(String.class))).thenReturn(usuariosEncontrados);

        RequestResult usuarioEncontrado = usuarioServiceImpl.buscarUsuarioPorNome("Dwight");

        Assertions.assertEquals(0, usuarioEncontrado.getStatusCode());
    }

    @Test
    public void shouldSearchUsuarioById(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        when(usuarioRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(usuario));

        RequestResult usuarioEncontrado = usuarioServiceImpl.buscarUsuarioPorId(1L);

        Assertions.assertEquals(1, usuarioEncontrado.getStatusCode());
    }

    @Test
    public void shouldNotSearchUsuarioById(){
        when(usuarioRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        RequestResult usuarioEncontrado = usuarioServiceImpl.buscarUsuarioPorId(1L);

        Assertions.assertEquals(0, usuarioEncontrado.getStatusCode());
    }

    @Test
    public void shouldEditUsuario(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        when(usuarioRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(usuario));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        RequestResult usuarioEditado = usuarioServiceImpl.editarUsuario(1L, "michael_scott", "111", "Michael Scott");

        Assertions.assertEquals(1, usuarioEditado.getStatusCode());
    }

    @Test
    public void shouldNotEditUsuario(){
        when(usuarioRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        RequestResult usuarioEditado = usuarioServiceImpl.editarUsuario(1L, "michael_scott", "111", "Michael Scott");

        Assertions.assertEquals(0, usuarioEditado.getStatusCode());
    }

    @Test
    public void shouldRemoveUsuario(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        when(usuarioRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(usuario));

        RequestResult usuarioRemovido = usuarioServiceImpl.removerUsuario(1L);

        Assertions.assertEquals(1, usuarioRemovido.getStatusCode());
    }

    @Test
    public void shouldNotRemoveUsuario(){

        when(usuarioRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        RequestResult usuarioRemovido = usuarioServiceImpl.removerUsuario(1L);

        Assertions.assertEquals(0, usuarioRemovido.getStatusCode());
    }

    @Test
    public void shouldListUsuarios(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        List<Usuario> usuariosExistentes = new ArrayList<>();
        usuariosExistentes.add(usuario);

        when(usuarioRepository.findAll()).thenReturn(usuariosExistentes);

        RequestResult usuarios = usuarioServiceImpl.listarUsuarios();

        Assertions.assertEquals(usuariosExistentes, usuarios.getData());
        Assertions.assertEquals(1, usuarios.getStatusCode());
    }

    @Test
    public void shouldNotListUsuarios(){

        List<Usuario> usuariosExistentes = new ArrayList<>();

        when(usuarioRepository.findAll()).thenReturn(usuariosExistentes);

        RequestResult usuarios = usuarioServiceImpl.listarUsuarios();

        Assertions.assertEquals(0, usuarios.getStatusCode());
    }
}
