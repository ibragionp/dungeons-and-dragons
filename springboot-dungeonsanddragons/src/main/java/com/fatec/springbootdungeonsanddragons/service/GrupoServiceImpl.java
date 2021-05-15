package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Grupo;
import com.fatec.springbootdungeonsanddragons.repository.GrupoRepository;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoServiceImpl implements GrupoService{

    @Autowired
    GrupoRepository grupoRepository;

    @Override
    public RequestResult cadastrarGrupo(Grupo grupo) {
        grupoRepository.save(grupo);
        return new RequestResult<>().success();
    }

    @Override
    public RequestResult buscarGrupo(Long id) {
        Grupo grupoExistente = grupoRepository.findById(id).orElse(null);
        if (!(grupoExistente == null)){
            return new RequestResult<>(grupoExistente);
        }
        return new RequestResult().error("Grupo não encontrado.");
    }

    @Override
    public RequestResult removerGrupo(Long id) {
        Grupo grupoExistente = grupoRepository.findById(id).orElse(null);
        if (!(grupoExistente == null)) {
            grupoRepository.deleteById(id);
            return new RequestResult().success();
        }
        return new RequestResult().error("Grupo não encontrado.");
    }
}
