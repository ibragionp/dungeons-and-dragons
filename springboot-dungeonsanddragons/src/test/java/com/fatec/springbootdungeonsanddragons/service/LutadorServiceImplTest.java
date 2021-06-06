package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Lutador;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.repository.LutadorRepository;
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
public class LutadorServiceImplTest {
    @InjectMocks
    LutadorServiceImpl lutadorServiceImpl;

    @Mock
    LutadorRepository lutadorRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateLutadorWithSuccess(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Lutador lutador = new Lutador();
        lutador.setId(1L);
        lutador.setProprietario(usuario);
        lutador.setNome("Kakarotto");
        lutador.setRaca("Saiyajin");
        lutador.setClasse("Super Saiyajin");
        lutador.setNivel(7);
        lutador.setAntecedente("Extraterrestre");
        lutador.setForca(6);
        lutador.setDestreza(5);
        lutador.setConstituicao(4);
        lutador.setInteligencia(3);
        lutador.setSabedoria(2);
        lutador.setCarisma(1);
        lutador.setdadosSuperioridade(9);

        when(lutadorRepository.save(any(Lutador.class))).thenReturn(lutador);

        RequestResult feiticeiroCadastrado = lutadorServiceImpl.cadastrarLutador(lutador);

        Assertions.assertEquals(1, feiticeiroCadastrado.getStatusCode());
    }

    @Test
    public void shouldSearchLutadorByName(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Lutador lutador = new Lutador();
        lutador.setId(1L);
        lutador.setProprietario(usuario);
        lutador.setNome("Kakarotto");
        lutador.setRaca("Saiyajin");
        lutador.setClasse("Super Saiyajin");
        lutador.setNivel(7);
        lutador.setAntecedente("Extraterrestre");
        lutador.setForca(6);
        lutador.setDestreza(5);
        lutador.setConstituicao(4);
        lutador.setInteligencia(3);
        lutador.setSabedoria(2);
        lutador.setCarisma(1);
        lutador.setdadosSuperioridade(9);
        List<Lutador> lutadoresEncontrados  = new ArrayList<>();
        lutadoresEncontrados.add(lutador);

        when(lutadorRepository.findByNome(any(String.class))).thenReturn(lutadoresEncontrados);

        RequestResult lutadoresExistentes = lutadorServiceImpl.buscarLutadorPorNome("Kakarotto");

        Assertions.assertEquals(1, lutadoresExistentes.getStatusCode());
    }

    @Test
    public void shouldNotSearchLutadorByName(){
        List<Lutador> lutadoresEncontrados  = new ArrayList<>();

        when(lutadorRepository.findByNome(any(String.class))).thenReturn(lutadoresEncontrados);

        RequestResult lutadoresExistentes = lutadorServiceImpl.buscarLutadorPorNome("Goku");

        Assertions.assertEquals(0, lutadoresExistentes.getStatusCode());
    }

    @Test
    public void shouldSearchLutadorById(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Lutador lutador = new Lutador();
        lutador.setId(1L);
        lutador.setProprietario(usuario);
        lutador.setNome("Kakarotto");
        lutador.setRaca("Saiyajin");
        lutador.setClasse("Super Saiyajin");
        lutador.setNivel(7);
        lutador.setAntecedente("Extraterrestre");
        lutador.setForca(6);
        lutador.setDestreza(5);
        lutador.setConstituicao(4);
        lutador.setInteligencia(3);
        lutador.setSabedoria(2);
        lutador.setCarisma(1);
        lutador.setdadosSuperioridade(9);

        when(lutadorRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(lutador));

        RequestResult lutadorEncontrado = lutadorServiceImpl.buscarLutadorPorId(1L);

        Assertions.assertEquals(1, lutadorEncontrado.getStatusCode());
    }

    @Test
    public void shouldNotSearchLutadorById(){
        when(lutadorRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        RequestResult lutadorEncontrado = lutadorServiceImpl.buscarLutadorPorId(1L);

        Assertions.assertEquals(0, lutadorEncontrado.getStatusCode());
    }

    @Test
    public void shouldEditLutador(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Lutador lutador = new Lutador();
        lutador.setId(1L);
        lutador.setProprietario(usuario);
        lutador.setNome("Kakarotto");
        lutador.setRaca("Saiyajin");
        lutador.setClasse("Super Saiyajin");
        lutador.setNivel(7);
        lutador.setAntecedente("Extraterrestre");
        lutador.setForca(6);
        lutador.setDestreza(5);
        lutador.setConstituicao(4);
        lutador.setInteligencia(3);
        lutador.setSabedoria(2);
        lutador.setCarisma(1);
        lutador.setdadosSuperioridade(9);

        when(lutadorRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(lutador));
        when(lutadorRepository.save(any(Lutador.class))).thenReturn(lutador);

        RequestResult lutadorEncontrado = lutadorServiceImpl.editarLutador(1L, usuario,
                "Goku", "Saiyajin",
                "Super Saiyajin", 7, "Extraterrestre",
                6,5,4,3,2,1,9);

        Assertions.assertEquals(1, lutadorEncontrado.getStatusCode());
    }

    @Test
    public void shouldNotEditLutador(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        when(lutadorRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        RequestResult lutadorEditado = lutadorServiceImpl.editarLutador(1L, usuario,
                "Goku", "Saiyajin",
                "Super Saiyajin", 7, "Extraterrestre",
                6,5,4,3,2,1,9);

        Assertions.assertEquals(0, lutadorEditado.getStatusCode());
    }

    @Test
    public void shouldRemoveLutador(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Lutador lutador = new Lutador();
        lutador.setId(1L);
        lutador.setProprietario(usuario);
        lutador.setNome("Kakarotto");
        lutador.setRaca("Saiyajin");
        lutador.setClasse("Super Saiyajin");
        lutador.setNivel(7);
        lutador.setAntecedente("Extraterrestre");
        lutador.setForca(6);
        lutador.setDestreza(5);
        lutador.setConstituicao(4);
        lutador.setInteligencia(3);
        lutador.setSabedoria(2);
        lutador.setCarisma(1);
        lutador.setdadosSuperioridade(9);

        when(lutadorRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(lutador));

        RequestResult lutadorRemovido = lutadorServiceImpl.removerLutador(1L);

        Assertions.assertEquals(1, lutadorRemovido.getStatusCode());
    }

    @Test
    public void shouldNotRemoveLutador(){

        when(lutadorRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        RequestResult lutadorRemovido = lutadorServiceImpl.removerLutador(1L);

        Assertions.assertEquals(0, lutadorRemovido.getStatusCode());
    }

    @Test
    public void shouldListLutadores(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Lutador lutador = new Lutador();
        lutador.setId(1L);
        lutador.setProprietario(usuario);
        lutador.setNome("Kakarotto");
        lutador.setRaca("Saiyajin");
        lutador.setClasse("Super Saiyajin");
        lutador.setNivel(7);
        lutador.setAntecedente("Extraterrestre");
        lutador.setForca(6);
        lutador.setDestreza(5);
        lutador.setConstituicao(4);
        lutador.setInteligencia(3);
        lutador.setSabedoria(2);
        lutador.setCarisma(1);
        lutador.setdadosSuperioridade(9);
        List<Lutador> lutadoresExistentes = new ArrayList<>();
        lutadoresExistentes.add(lutador);

        when(lutadorRepository.findAll()).thenReturn(lutadoresExistentes);

        RequestResult lutadores = lutadorServiceImpl.listarLutadores();

        Assertions.assertEquals(lutadoresExistentes, lutadores.getData());
        Assertions.assertEquals(1, lutadores.getStatusCode());
    }

    @Test
    public void shouldNotListLutadores(){

        List<Lutador> lutadoresExistentes = new ArrayList<>();

        when(lutadorRepository.findAll()).thenReturn(lutadoresExistentes);

        RequestResult lutadores = lutadorServiceImpl.listarLutadores();

        Assertions.assertEquals(0, lutadores.getStatusCode());
    }

}
