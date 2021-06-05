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
import com.fatec.springbootdungeonsanddragons.repository.UsuarioRepository;
import com.fatec.springbootdungeonsanddragons.service.UsuarioService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired
    private UsuarioRepository usuarioRepo;
    
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

    // Testes de inserir Feiticeiro
    @Test
    void testaInsercaoFeiticeiro() {
        Feiticeiro feiticeiro = new Feiticeiro();
        
        // feiticeiro.setProprietario(usuario);
        feiticeiro.setNome("Shang Tsung");
        feiticeiro.setRaca("Chinês");
        feiticeiro.setClasse("Feiticeiro");
        feiticeiro.setNivel(1);
        feiticeiro.setAntecedente("John Tobias");
        feiticeiro.setForca(2);
        feiticeiro.setDestreza(3);
        feiticeiro.setConstituicao(4);
        feiticeiro.setInteligencia(5);
        feiticeiro.setSabedoria(6);
        feiticeiro.setCarisma(7);
        feiticeiro.setMagiasConhecidas(8);
        feiticeiro.setModificadorHabilidade(9);

        feiticeiroRepo.save(feiticeiro);
        assertNotNull(feiticeiro.getId());
    }
    
}