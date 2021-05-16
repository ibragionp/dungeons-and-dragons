package com.fatec.springbootdungeonsanddragons;

import java.util.List;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

import com.fatec.springbootdungeonsanddragons.entity.Feiticeiro;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.entity.Personagem;
import com.fatec.springbootdungeonsanddragons.entity.Grupo;
import com.fatec.springbootdungeonsanddragons.entity.Lutador;
import com.fatec.springbootdungeonsanddragons.entity.Admin;
import com.fatec.springbootdungeonsanddragons.service.FeiticeiroService.java;
import com.fatec.springbootdungeonsanddragons.service.GrupoService.java;
import com.fatec.springbootdungeonsanddragons.service.UsuarioService.java;
import com.fatec.springbootdungeonsanddragons.service.LutadorService.java;
import com.fatec.springbootdungeonsanddragons.repository.FeiticeiroRepository;
import com.fatec.springbootdungeonsanddragons.repository.GrupoRepository;
import com.fatec.springbootdungeonsanddragons.repository.LutadorRepository;
import com.fatec.springbootdungeonsanddragons.repository.UsuarioRepository;

@SpringBootTest
@Transactional
class SpringBootAppApplicationTests {

    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    private AutorizacaoRepository autRepo;

    @Autowired
    private PersonagemRepository personagemRepo;

    @Autowired
    private ClasseRepository classeRepo;

    @Autowired
    private SegurancaService segService;

    @Autowired
    private NovoPersonagemService perService;

    // TESTES DE USUARIO
	@Test
	void contextLoads() {
    }
    @Test
    void testaInsercao() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("usuario_teste");
        usuario.setSenha("senha");
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
            Autorizacao aut = new Autorizacao();
            aut.setTipo("ROLE_USER");
            autRepo.save(aut);
            usuario.getAutorizacoes().add(aut);
        usuario.setNomeExibicao("teste");

        usuarioRepo.save(usuario);
        assertNotNull(usuario.getId());
    }
    // TESTES DE PERSONAGEM
    @Test
    void testaPersonagem() {
        Personagem personagem = new Personagem();
            personagem.setProprietario(usuarioRepo.findUsuarioByNomeUsuario("rodrigocr16"));
            personagem.setClasse(classeRepo.findClasseByNome("bardo"));
            personagem.setNome("seeker");
        personagemRepo.save(personagem);
        assertNotNull(personagem.getId());
    }
}