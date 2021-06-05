package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Feiticeiro;
import com.fatec.springbootdungeonsanddragons.entity.Grupo;
import com.fatec.springbootdungeonsanddragons.entity.Personagem;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.repository.GrupoRepository;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GrupoServiceImplTest {

    @InjectMocks
    GrupoServiceImpl grupoServiceImpl;

    @Mock
    GrupoRepository grupoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateGrupoWithSuccess(){
        Usuario usuario = new Usuario();
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

        Set<Personagem> integrantes = new HashSet<Personagem>();
        integrantes.add(feiticeiro);

        Grupo grupo = new Grupo();
        grupo.setGrupoId(1L);
        grupo.setMestre(usuario);
        grupo.setNomeGrupo("Turma do Bairro");
        grupo.setIntegrantes(integrantes);

        when(grupoRepository.save(any(Grupo.class))).thenReturn(grupo);

        RequestResult grupoCadastrado = grupoServiceImpl.cadastrarGrupo(grupo);

        Assertions.assertEquals(1, grupoCadastrado.getStatusCode());
    }

    @Test
    public void shouldSearchGrupoById(){
        Usuario usuario = new Usuario();
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

        Set<Personagem> integrantes = new HashSet<Personagem>();
        integrantes.add(feiticeiro);

        Grupo grupo = new Grupo();
        grupo.setGrupoId(1L);
        grupo.setMestre(usuario);
        grupo.setNomeGrupo("Turma do Bairro");
        grupo.setIntegrantes(integrantes);

        when(grupoRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(grupo));

        RequestResult grupoEncontrado = grupoServiceImpl.buscarGrupo(1L);

        Assertions.assertEquals(1, grupoEncontrado.getStatusCode());
    }

    @Test
    public void shouldNotSearchGrupoById(){
        when(grupoRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        RequestResult grupoEncontrado = grupoServiceImpl.buscarGrupo(1L);

        Assertions.assertEquals(0, grupoEncontrado.getStatusCode());
    }

    @Test
    public void shouldRemoveGrupo(){
        Usuario usuario = new Usuario();
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

        Set<Personagem> integrantes = new HashSet<Personagem>();
        integrantes.add(feiticeiro);

        Grupo grupo = new Grupo();
        grupo.setGrupoId(1L);
        grupo.setMestre(usuario);
        grupo.setNomeGrupo("Turma do Bairro");
        grupo.setIntegrantes(integrantes);

        when(grupoRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(grupo));

        RequestResult grupoRemovido = grupoServiceImpl.removerGrupo(1L);

        Assertions.assertEquals(1, grupoRemovido.getStatusCode());
    }

    @Test
    public void shouldNotRemoveGrupo(){

        when(grupoRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

        RequestResult grupoRemovido = grupoServiceImpl.removerGrupo(1L);

        Assertions.assertEquals(0, grupoRemovido.getStatusCode());
    }
}
