package com.fatec.springbootdungeonsanddragons.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "GRU_GRUPO")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRU_ID_UNIQUE")
    private Long id;

    @Column(name = "GRU_ID")
    private Long grupoId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GRU_MESTRE")
    private Usuario mestre;

    @Column(name = "GRU_NOME")
    private String nomeGrupo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "INT_INTEGRANTE",
            joinColumns = { @JoinColumn(name = "GRU_ID")},
            inverseJoinColumns = { @JoinColumn(name = "PER_ID")}
    )

    private Set<Personagem> integrantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public Usuario getMestre() {
        return mestre;
    }

    public void setMestre(Usuario mestre) {
        this.mestre = mestre;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public Set<Personagem> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(Set<Personagem> integrantes) {
        this.integrantes = integrantes;
    }
}
