package com.fatec.springbootdungeonsanddragons.entity;
import java.util.UUID;
import org.hibernate.annotations.Type;
import javax.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USU_ADMINISTRADOR", discriminatorType = DiscriminatorType.STRING)
@Table(name = "USU_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USU_ID")
    private Long id;

    @Column(name = "USU_NOME_USUARIO")
    private String nomeUsuario;

    @Column(name = "USU_SENHA")
    private String senha;

    @Column(name = "USU_NOME_EXIBICAO")
    private String nomeExibicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public void setNomeExibicao(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }
}
