package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Feiticeiro;
import com.fatec.springbootdungeonsanddragons.entity.Lutador;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.springframework.stereotype.Service;


public interface FeiticeiroService {
    public RequestResult cadastrarFeiticeiro(Feiticeiro feiticeiro);
    public RequestResult buscarFeiticeiroPorNome(String nome);
    public RequestResult buscarFeiticeiroPorId(Long id);
    public RequestResult editarFeiticeiro(Long id, Usuario usuario, String nome,
                                          String raca, String classe, Integer nivel, String antecedente, Integer forca,
                                          Integer destreza, Integer constituicao, Integer inteligencia,
                                          Integer sabedoria, Integer carisma, Integer magiasConhecidas,
                                          Integer modificadorHabilidade);
    public RequestResult removerFeiticeiro(Long id);
    public RequestResult listarFeiticeiros();
}
