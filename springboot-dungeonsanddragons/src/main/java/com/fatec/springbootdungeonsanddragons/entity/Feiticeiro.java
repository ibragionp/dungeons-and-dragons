package com.fatec.springbootdungeonsanddragons.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "FEI_FEITICEIRO")
@PrimaryKeyJoinColumn(name = "FEI_ID")
// @DiscriminatorValue("Persona")
public class Feiticeiro extends Personagem {

    @Column(name = "FEI_MAGIAS_CONHECIDAS")
    private Integer magiasConhecidas;

    @Column(name = "FEI_MODIFICADOR_HABILIDADE")
    private Integer modificadorHabilidade;


    public Integer getMagiasConhecidas() {
        return magiasConhecidas;
    }
    public void setMagiasConhecidas(Integer magiasConhecidas) {
        this.magiasConhecidas = magiasConhecidas;
    }

    public Integer getModificadorHabilidade() {
        return modificadorHabilidade;
    }
    public void setModificadorHabilidade(Integer modificadorHabilidade) {
        this.modificadorHabilidade = modificadorHabilidade;
    }
}
