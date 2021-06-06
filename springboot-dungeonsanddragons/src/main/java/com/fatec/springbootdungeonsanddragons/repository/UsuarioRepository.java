package com.fatec.springbootdungeonsanddragons.repository;

import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    List<Usuario> findByNomeUsuario(String nomeUsuario);

    Usuario findById(long idUsuario);
}
