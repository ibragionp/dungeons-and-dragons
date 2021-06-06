package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Feiticeiro;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.repository.FeiticeiroRepository;
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
public class FeiticeiroServiceImplTest {

    @InjectMocks
    FeiticeiroServiceImpl feiticeiroServiceImpl;

    @Mock
    FeiticeiroRepository feiticeiroRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateFeiticeiroWithSuccess(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Feiticeiro feiticeiro = new Feiticeiro();
        feiticeiro.setId(1L);
        feiticeiro.setProprietario(usuario);
        feiticeiro.setNome("Epifalius Merlin");
        feiticeiro.setRaca("Bruxo");
        feiticeiro.setClasse("Mesopotamia");
        feiticeiro.setNivel(7);
        feiticeiro.setAntecedente("Merlin");
        feiticeiro.setForca(6);
        feiticeiro.setDestreza(5);
        feiticeiro.setConstituicao(4);
        feiticeiro.setInteligencia(3);
        feiticeiro.setSabedoria(2);
        feiticeiro.setCarisma(1);
        feiticeiro.setMagiasConhecidas(9);
        feiticeiro.setModificadorHabilidade(8);

        when(feiticeiroRepository.save(any(Feiticeiro.class))).thenReturn(feiticeiro);

        RequestResult feiticeiroCadastrado = feiticeiroServiceImpl.cadastrarFeiticeiro(feiticeiro);

        Assertions.assertEquals(1, feiticeiroCadastrado.getStatusCode());
    }

    @Test
    public void shouldSearchFeiticeiroByName(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Feiticeiro feiticeiro = new Feiticeiro();
        feiticeiro.setId(1L);
        feiticeiro.setProprietario(usuario);
        feiticeiro.setNome("Epifalius Merlin");
        feiticeiro.setRaca("Bruxo");
        feiticeiro.setClasse("Mesopotamia");
        feiticeiro.setNivel(7);
        feiticeiro.setAntecedente("Merlin");
        feiticeiro.setForca(6);
        feiticeiro.setDestreza(5);
        feiticeiro.setConstituicao(4);
        feiticeiro.setInteligencia(3);
        feiticeiro.setSabedoria(2);
        feiticeiro.setCarisma(1);
        feiticeiro.setMagiasConhecidas(9);
        feiticeiro.setModificadorHabilidade(8);
        List<Feiticeiro> feiticeirosEncontrados  = new ArrayList<>();
        feiticeirosEncontrados.add(feiticeiro);

        when(feiticeiroRepository.findByNome(any(String.class))).thenReturn(feiticeirosEncontrados);

        RequestResult feiticeirosExistentes = feiticeiroServiceImpl.buscarFeiticeiroPorNome("Epifalius Merlin");

        Assertions.assertEquals(1, feiticeirosExistentes.getStatusCode());
    }

    @Test
    public void shouldNotSearchFeiticeiroByName(){
        List<Feiticeiro> feiticeirosEncontrados  = new ArrayList<>();

        when(feiticeiroRepository.findByNome(any(String.class))).thenReturn(feiticeirosEncontrados);

        RequestResult feiticeirosExistentes = feiticeiroServiceImpl.buscarFeiticeiroPorNome("Epifalius Merlin");

        Assertions.assertEquals(0, feiticeirosExistentes.getStatusCode());
    }

    @Test
    public void shouldSearchFeiticeiroById(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Feiticeiro feiticeiro = new Feiticeiro();
        feiticeiro.setId(1L);
        feiticeiro.setProprietario(usuario);
        feiticeiro.setNome("Epifalius Merlin");
        feiticeiro.setRaca("Bruxo");
        feiticeiro.setClasse("Mesopotamia");
        feiticeiro.setNivel(7);
        feiticeiro.setAntecedente("Merlin");
        feiticeiro.setForca(6);
        feiticeiro.setDestreza(5);
        feiticeiro.setConstituicao(4);
        feiticeiro.setInteligencia(3);
        feiticeiro.setSabedoria(2);
        feiticeiro.setCarisma(1);
        feiticeiro.setMagiasConhecidas(9);
        feiticeiro.setModificadorHabilidade(8);

        when(feiticeiroRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(feiticeiro));

        RequestResult feiticeiroEncontrado = feiticeiroServiceImpl.buscarFeiticeiroPorId(1L);

        Assertions.assertEquals(1, feiticeiroEncontrado.getStatusCode());
    }

    @Test
    public void shouldNotSearchFeiticeiroById(){
        when(feiticeiroRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        RequestResult feiticeiroEncontrado = feiticeiroServiceImpl.buscarFeiticeiroPorId(1L);

        Assertions.assertEquals(0, feiticeiroEncontrado.getStatusCode());
    }

    @Test
    public void shouldEditFeiticeiro(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Feiticeiro feiticeiro = new Feiticeiro();
        feiticeiro.setId(1L);
        feiticeiro.setProprietario(usuario);
        feiticeiro.setNome("Epifalius Merlin");
        feiticeiro.setRaca("Bruxo");
        feiticeiro.setClasse("Mesopotamia");
        feiticeiro.setNivel(7);
        feiticeiro.setAntecedente("Merlin");
        feiticeiro.setForca(6);
        feiticeiro.setDestreza(5);
        feiticeiro.setConstituicao(4);
        feiticeiro.setInteligencia(3);
        feiticeiro.setSabedoria(2);
        feiticeiro.setCarisma(1);
        feiticeiro.setMagiasConhecidas(9);
        feiticeiro.setModificadorHabilidade(8);

        when(feiticeiroRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(feiticeiro));
        when(feiticeiroRepository.save(any(Feiticeiro.class))).thenReturn(feiticeiro);

        RequestResult feiticeiroEditado = feiticeiroServiceImpl.editarFeiticeiro(1L, usuario,
                "Epifalius Merlin", "Druida",
                "Mesopotamia", 7, "Merlin",
                6,5,4,3,2,1,9,8);

        Assertions.assertEquals(1, feiticeiroEditado.getStatusCode());
    }

    @Test
    public void shouldNotEditFeiticeiro(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        when(feiticeiroRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        RequestResult feiticeiroEditado = feiticeiroServiceImpl.editarFeiticeiro(1L, usuario,
                "Epifalius Merlin", "Druida",
                "Mesopotamia", 7, "Merlin",
                6,5,4,3,2,1,9,8);

        Assertions.assertEquals(0, feiticeiroEditado.getStatusCode());
    }

    @Test
    public void shouldRemoveFeiticeiro(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Feiticeiro feiticeiro = new Feiticeiro();
        feiticeiro.setId(1L);
        feiticeiro.setProprietario(usuario);
        feiticeiro.setNome("Epifalius Merlin");
        feiticeiro.setRaca("Bruxo");
        feiticeiro.setClasse("Mesopotamia");
        feiticeiro.setNivel(7);
        feiticeiro.setAntecedente("Merlin");
        feiticeiro.setForca(6);
        feiticeiro.setDestreza(5);
        feiticeiro.setConstituicao(4);
        feiticeiro.setInteligencia(3);
        feiticeiro.setSabedoria(2);
        feiticeiro.setCarisma(1);
        feiticeiro.setMagiasConhecidas(9);
        feiticeiro.setModificadorHabilidade(8);

        when(feiticeiroRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(feiticeiro));

        RequestResult feiticeiroRemovido = feiticeiroServiceImpl.removerFeiticeiro(1L);

        Assertions.assertEquals(1, feiticeiroRemovido.getStatusCode());
    }

    @Test
    public void shouldNotRemoveFeiticeiro(){

        when(feiticeiroRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        RequestResult feiticeiroRemovido = feiticeiroServiceImpl.removerFeiticeiro(1L);

        Assertions.assertEquals(0, feiticeiroRemovido.getStatusCode());
    }

    @Test
    public void shouldListFeiticeiros(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeUsuario("michael");
        usuario.setSenha("111");
        usuario.setNomeExibicao("Michael Scott");

        Feiticeiro feiticeiro = new Feiticeiro();
        feiticeiro.setId(1L);
        feiticeiro.setProprietario(usuario);
        feiticeiro.setNome("Epifalius Merlin");
        feiticeiro.setRaca("Bruxo");
        feiticeiro.setClasse("Mesopotamia");
        feiticeiro.setNivel(7);
        feiticeiro.setAntecedente("Merlin");
        feiticeiro.setForca(6);
        feiticeiro.setDestreza(5);
        feiticeiro.setConstituicao(4);
        feiticeiro.setInteligencia(3);
        feiticeiro.setSabedoria(2);
        feiticeiro.setCarisma(1);
        feiticeiro.setMagiasConhecidas(9);
        feiticeiro.setModificadorHabilidade(8);
        List<Feiticeiro> feiticeirosExistentes = new ArrayList<>();
        feiticeirosExistentes.add(feiticeiro);

        when(feiticeiroRepository.findAll()).thenReturn(feiticeirosExistentes);

        RequestResult feiticeiros = feiticeiroServiceImpl.listarFeiticeiros();

        Assertions.assertEquals(feiticeirosExistentes, feiticeiros.getData());
        Assertions.assertEquals(1, feiticeiros.getStatusCode());
    }

    @Test
    public void shouldNotListFeiticeiros(){

        List<Feiticeiro> feiticeirosExistentes = new ArrayList<>();

        when(feiticeiroRepository.findAll()).thenReturn(feiticeirosExistentes);

        RequestResult feiticeiros = feiticeiroServiceImpl.listarFeiticeiros();

        Assertions.assertEquals(0, feiticeiros.getStatusCode());
    }

}
