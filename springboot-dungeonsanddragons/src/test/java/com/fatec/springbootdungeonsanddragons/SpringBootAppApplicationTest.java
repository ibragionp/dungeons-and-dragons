package com.fatec.springbootdungeonsanddragons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.springbootdungeonsanddragons.repository.FeiticeiroRepository;
import com.fatec.springbootdungeonsanddragons.repository.UsuarioRepository;
import com.fatec.springbootdungeonsanddragons.service.UsuarioService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    private FeiticeiroRepository feitiRepo;

    @Autowired
    private UsuarioService usuarioService;

    // TESTES PRINCIPAIS
	@Test
	void contextLoads() {
    }
    @Test
    void testaInsercao() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Povs");
        usuario.setSenha("senha");
        usuario.setNomeExibicao("teste");

        usuarioRepo.save(usuario);
        assertNotNull(usuario.getId());
    }

    // TESTES DE BUSCA
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
}