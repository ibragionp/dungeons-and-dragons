package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Lutador;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface LutadorService {
    public RequestResult cadastrarLutador(Lutador lutador);
    public RequestResult buscarLutadorPorNome(String nome);
    public RequestResult buscarLutadorPorId(Long id);
    public RequestResult editarLutador(Long id, Usuario usuario, String nome, String raca,
                                       String classe, Integer nivel, String antecedente, Integer forca,
                                       Integer destreza, Integer constituicao, Integer inteligencia,
                                       Integer sabedoria, Integer carisma, Integer dadosSuperioridade);
    public RequestResult removerLutador(Long id);
    public RequestResult listarLutadores();
}
