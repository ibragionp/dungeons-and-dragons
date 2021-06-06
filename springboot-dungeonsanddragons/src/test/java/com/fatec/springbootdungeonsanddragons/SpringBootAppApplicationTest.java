package com.fatec.springbootdungeonsanddragons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fatec.springbootdungeonsanddragons.entity.Feiticeiro;
import com.fatec.springbootdungeonsanddragons.entity.Personagem;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.springbootdungeonsanddragons.repository.FeiticeiroRepository;
import com.fatec.springbootdungeonsanddragons.repository.LutadorRepository;
import com.fatec.springbootdungeonsanddragons.repository.PersonagemRepository;
import com.fatec.springbootdungeonsanddragons.repository.UsuarioRepository;
import com.fatec.springbootdungeonsanddragons.service.UsuarioService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    private PersonagemRepository personagemRepo;

    @Autowired
    private FeiticeiroRepository feiticeiroRepo;

    @Autowired
    private LutadorRepository lutadorRepo;
    
    // TESTES PRINCIPAIS
	@Test
	void contextLoads() {
    }

    // TESTES DE INSERIR USUARIO
    @Test
    void testaInsercao() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Povs");
        usuario.setSenha("senha");
        usuario.setNomeExibicao("teste");

        usuarioRepo.save(usuario);
        assertNotNull(usuario.getId());
    }

    // TESTES DE BUSCA USUARIO
    @Test
    void testaBuscaUsuarioNomeContains() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Povs");
        usuario.setSenha("senha");
        usuario.setNomeExibicao("teste");
        usuarioRepo.save(usuario);

        List<Usuario> usuarios = usuarioRepo.findByNomeUsuario("Povs");
        System.out.print(usuarios);
        assertTrue(!usuarios.isEmpty());
    }

    // // Testes de inserir Feiticeiro
    // @Test
    // void testaInsercaoFeiticeiro() {

    //     Usuario usuario = new Usuario();
    //     usuario.setNomeUsuario("Povs");
    //     usuario.setSenha("senha");
    //     usuario.setNomeExibicao("teste");
    //     usuarioRepo.save(usuario);

    //     Personagem personagem = new Personagem();        
    //     personagem.setProprietario(usuario);
    //     personagem.setNome("Shang Tsung");
    //     personagem.setRaca("Chinês");
    //     personagem.setClasse("Feiticeiro");
    //     personagem.setNivel(1);
    //     personagem.setAntecedente("John Tobias");
    //     personagem.setForca(2);
    //     personagem.setDestreza(3);
    //     personagem.setConstituicao(4);
    //     personagem.setInteligencia(5);
    //     personagem.setSabedoria(6);
    //     personagem.setCarisma(7);

    //     personagemRepo.save(personagem);

    //     Feiticeiro feiticeiro = new Feiticeiro();
        
    //     feiticeiro.setMagiasConhecidas(8);
    //     feiticeiro.setModificadorHabilidade(9);

    //     feiticeiroRepo.save(feiticeiro);
    //     assertNotNull(feiticeiro.getId());
    // }

    
    // // Testes de inserir Personagem
    // @Test
    // void testaInsercaoPersonagem() {

    //     Usuario usuario = new Usuario();
    //     usuario.setNomeUsuario("Povs");
    //     usuario.setSenha("senha");
    //     usuario.setNomeExibicao("teste");
    //     usuarioRepo.save(usuario);

    //     assertNotNull(usuario.getId());

    //     // Long id = (long)1;
    //     String nome = "Shang Tsung", 
    //            raca = "Chinês", 
    //            classe = "Feiticeiro", 
    //            antecedente = "John Tobias";
    //     Integer nivel = 1, 
    //             forca = 2, 
    //             destreza = 3, 
    //             constituicao = 4, 
    //             inteligencia = 5, 
    //             sabedoria = 6, 
    //             carisma = 7;

    //     Personagem personagem = new Personagem();        
    //     personagem.setProprietario(usuario);
    //     personagem.setNome(nome);
    //     personagem.setRaca(raca);
    //     personagem.setClasse(classe);
    //     personagem.setNivel(nivel);
    //     personagem.setAntecedente(antecedente);
    //     personagem.setForca(forca);
    //     personagem.setDestreza(destreza);
    //     personagem.setConstituicao(constituicao);
    //     personagem.setInteligencia(inteligencia);
    //     personagem.setSabedoria(sabedoria);
    //     personagem.setCarisma(carisma);

    //     personagemRepo.save(personagem);
    //     // assertNotNull(personagem.getId());
    // }

    // TESTES DE DELETAR USUARIO
    @Test
    void testaExcluir() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Povs");
        usuario.setSenha("senha");
        usuario.setNomeExibicao("teste");
        usuarioRepo.save(usuario);
        assertNotNull(usuario.getId());

        Usuario usuarioFindById = usuarioRepo.findById((long)usuario.getId());
        System.out.print(usuarioFindById);
        assertTrue(usuarioFindById != null);
        
        usuarioRepo.deleteById(usuarioFindById.getId());
        Usuario usuarioDelete = usuarioRepo.findById((long)usuario.getId());
        assertFalse(usuarioDelete != null);
    }
    
}