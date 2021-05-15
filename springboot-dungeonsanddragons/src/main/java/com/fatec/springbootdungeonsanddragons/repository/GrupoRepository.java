package com.fatec.springbootdungeonsanddragons.repository;

import com.fatec.springbootdungeonsanddragons.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}
