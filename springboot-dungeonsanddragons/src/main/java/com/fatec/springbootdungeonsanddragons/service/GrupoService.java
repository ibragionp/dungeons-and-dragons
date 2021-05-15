package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Grupo;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;


public interface GrupoService {

    public RequestResult cadastrarGrupo(Grupo grupo);
    public RequestResult buscarGrupo(Long id);
    public RequestResult removerGrupo(Long id);
}
