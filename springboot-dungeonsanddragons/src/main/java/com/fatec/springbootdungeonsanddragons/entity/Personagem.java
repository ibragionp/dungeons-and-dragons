package com.fatec.springbootdungeonsanddragons.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @AttributeOverride(name = "id", column = @Column(name = "PER_ID_UNIQUE"))
// @DiscriminatorColumn(name = "PER_PERSONA", discriminatorType = DiscriminatorType.STRING)
// @DiscriminatorColumn(name = "PER_LUTADOR", discriminatorType = DiscriminatorType.STRING)
@Table(name = "PER_PERSONAGEM")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PER_ID_UNIQUE")
    private Long id;

    @Column(name = "PER_ID")
    private Long personagemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PER_PROPRIETARIO")
    private Usuario proprietario;

    @Column(name = "PER_NOME")
    private String nome;

    @Column(name = "PER_RACA")
    private String raca;

    @Column(name = "PER_CLASSE")
    private String classe;

    @Column(name = "PER_NIVEL")
    private Integer nivel;

    @Column(name = "PER_ANTECEDENTE")
    private String antecedente;

    @Column(name = "PER_FORCA")
    private Integer forca;

    @Column(name = "PER_DESTREZA")
    private Integer destreza;

    @Column(name = "PER_CONSTITUICAO")
    private Integer constituicao;

    @Column(name = "PER_INTELIGENCIA")
    private Integer inteligencia;

    @Column(name = "PER_SABEDORIA")
    private Integer sabedoria;

    @Column(name = "PER_CARISMA", columnDefinition = "INT")
    private Integer carisma;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonagemId() {
        return personagemId;
    }

    public void setPersonagemId(Long personagemId) {
        this.personagemId = personagemId;
    }

    public Usuario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Usuario proprietario) {
        this.proprietario = proprietario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getDestreza() {
        return destreza;
    }

    public void setDestreza(Integer destreza) {
        this.destreza = destreza;
    }

    public Integer getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(Integer constituicao) {
        this.constituicao = constituicao;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Integer getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(Integer sabedoria) {
        this.sabedoria = sabedoria;
    }

    public Integer getCarisma() {
        return carisma;
    }

    public void setCarisma(Integer carisma) {
        this.carisma = carisma;
    }
}
