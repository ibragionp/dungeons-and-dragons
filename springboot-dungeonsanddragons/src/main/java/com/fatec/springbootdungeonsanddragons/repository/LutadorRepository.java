package com.fatec.springbootdungeonsanddragons.repository;

import com.fatec.springbootdungeonsanddragons.entity.Lutador;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LutadorRepository extends JpaRepository<Lutador, Long> {
    List<Lutador> findByNome(String nome);
}
