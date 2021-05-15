package com.fatec.springbootdungeonsanddragons.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "LUT_LUTADOR")
@PrimaryKeyJoinColumn(name = "LUT_ID")
public class Lutador extends Personagem {

        @Column(name = "LUT_DADOS_SUPERIORIDADE")
        private Integer dadosSuperioridade;

        public Integer getdadosSuperioridade() {
            return dadosSuperioridade;
        }

        public void setdadosSuperioridade(Integer dadosSuperioridade) {
            this.dadosSuperioridade = dadosSuperioridade;
        }
}
