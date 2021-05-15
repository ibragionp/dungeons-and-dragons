package com.fatec.springbootdungeonsanddragons.repository;

import com.fatec.springbootdungeonsanddragons.entity.Feiticeiro;
import com.fatec.springbootdungeonsanddragons.entity.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeiticeiroRepository extends JpaRepository<Feiticeiro, Long> {
    List<Feiticeiro> findByNome(String nome);
}
