package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Feiticeiro;
import com.fatec.springbootdungeonsanddragons.entity.Lutador;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.repository.FeiticeiroRepository;
import com.fatec.springbootdungeonsanddragons.repository.LutadorRepository;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeiticeiroServiceImpl implements FeiticeiroService{

    @Autowired
    FeiticeiroRepository feiticeiroRepository;

    @Override
    public RequestResult cadastrarFeiticeiro(Feiticeiro feiticeiro) {
        feiticeiroRepository.save(feiticeiro);
        return new RequestResult<>().success();
    }

    @Override
    public RequestResult buscarFeiticeiroPorNome(String nome) {
        List<Feiticeiro> feiticeirosExistentes = feiticeiroRepository.findByNome(nome);
        if (!(feiticeirosExistentes.isEmpty())){
            return new RequestResult<>(feiticeirosExistentes);
        }
        return new RequestResult().error("Feiticeiro não encontrado.");
    }

    @Override
    public RequestResult buscarFeiticeiroPorId(Long id) {
        Feiticeiro feiticeiroExistente = feiticeiroRepository.findById(id).orElse(null);
        if (!(feiticeiroExistente == null)){
            return new RequestResult<>(feiticeiroExistente);
        }
        return new RequestResult().error("Feiticeiro não encontrado.");
    }

    @Override
    public RequestResult editarFeiticeiro(Long id, Usuario usuario, String nome, String raca,
                                          String classe, Integer nivel, String antecedente, Integer forca,
                                          Integer destreza, Integer constituicao, Integer inteligencia,
                                          Integer sabedoria, Integer carisma, Integer magiasConhecidas,
                                          Integer modificadorHabilidade) {
        Feiticeiro feiticeiroExistente = feiticeiroRepository.findById(id).orElse(null);
        if (!(feiticeiroExistente == null)){
            feiticeiroExistente.setProprietario(usuario);
            feiticeiroExistente.setNome(nome);
            feiticeiroExistente.setProprietario(usuario);
            feiticeiroExistente.setRaca(raca);
            feiticeiroExistente.setClasse(classe);
            feiticeiroExistente.setNivel(nivel);
            feiticeiroExistente.setAntecedente(antecedente);
            feiticeiroExistente.setForca(forca);
            feiticeiroExistente.setDestreza(destreza);
            feiticeiroExistente.setConstituicao(constituicao);
            feiticeiroExistente.setInteligencia(inteligencia);
            feiticeiroExistente.setSabedoria(sabedoria);
            feiticeiroExistente.setCarisma(carisma);
            feiticeiroExistente.setMagiasConhecidas(magiasConhecidas);
            feiticeiroExistente.setModificadorHabilidade(modificadorHabilidade);
            feiticeiroRepository.save(feiticeiroExistente);
            return new RequestResult().success();
        }
        return new RequestResult().error("Feiticeiro não encontrado.");
    }

    @Override
    public RequestResult removerFeiticeiro(Long id) {
        Feiticeiro feiticeiroExistente = feiticeiroRepository.findById(id).orElse(null);
        if (!(feiticeiroExistente == null)){
            feiticeiroRepository.deleteById(id);
            return new RequestResult().success();
        }
        return new RequestResult().error("Feiticeiro não encontrado.");
    }

    @Override
    public RequestResult listarFeiticeiros() {
        List<Feiticeiro> feiticeiroExistente = feiticeiroRepository.findAll();
        if (!(feiticeiroExistente.isEmpty())){
            return new RequestResult<>(feiticeiroExistente);
        }
        return new RequestResult().error("Não foram encontrados feiticeiros.");
    }
}
