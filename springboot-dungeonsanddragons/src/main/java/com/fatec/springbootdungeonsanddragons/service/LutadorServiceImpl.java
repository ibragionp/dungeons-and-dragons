package com.fatec.springbootdungeonsanddragons.service;

import com.fatec.springbootdungeonsanddragons.entity.Lutador;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.repository.LutadorRepository;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LutadorServiceImpl implements LutadorService{

    @Autowired
    LutadorRepository lutadorRepository;

    @Override
    public RequestResult cadastrarLutador(Lutador lutador) {
        lutadorRepository.save(lutador);
        return new RequestResult<>().success();
    }

    @Override
    public RequestResult buscarLutadorPorNome(String nome) {
        List<Lutador> lutadoresExistentes = lutadorRepository.findByNome(nome);
        if (!(lutadoresExistentes.isEmpty())){
            return new RequestResult<>(lutadoresExistentes);
        }
        return new RequestResult().error("Lutador não encontrado.");
    }

    @Override
    public RequestResult buscarLutadorPorId(Long id) {
        Lutador lutadorExistente = lutadorRepository.findById(id).orElse(null);
        if (!(lutadorExistente == null)){
            return new RequestResult<>(lutadorExistente);
        }
        return new RequestResult().error("Lutador não encontrado.");
    }

    @Override
    public RequestResult editarLutador(Long id, Usuario usuario, String nome, String raca,
                                       String classe, Integer nivel, String antecedente, Integer forca,
                                       Integer destreza, Integer constituicao, Integer inteligencia,
                                       Integer sabedoria, Integer carisma, Integer dadosSuperioridade) {
        Lutador lutadorExistente = lutadorRepository.findById(id).orElse(null);
        if (!(lutadorExistente == null)){
            lutadorExistente.setProprietario(usuario);
            lutadorExistente.setNome(nome);
            lutadorExistente.setProprietario(usuario);
            lutadorExistente.setRaca(raca);
            lutadorExistente.setClasse(classe);
            lutadorExistente.setNivel(nivel);
            lutadorExistente.setAntecedente(antecedente);
            lutadorExistente.setForca(forca);
            lutadorExistente.setDestreza(destreza);
            lutadorExistente.setConstituicao(constituicao);
            lutadorExistente.setInteligencia(inteligencia);
            lutadorExistente.setSabedoria(sabedoria);
            lutadorExistente.setCarisma(carisma);
            lutadorExistente.setdadosSuperioridade(dadosSuperioridade);
            lutadorRepository.save(lutadorExistente);
            return new RequestResult().success();
        }
        return new RequestResult().error("Lutador não encontrado.");
    }

    @Override
    public RequestResult removerLutador(Long id) {
        Lutador lutadorExistente = lutadorRepository.findById(id).orElse(null);
        if (!(lutadorExistente == null)){
            lutadorRepository.deleteById(id);
            return new RequestResult().success();
        }
        return new RequestResult().error("Lutador não encontrado.");
    }

    @Override
    public RequestResult listarLutadores() {
        List<Lutador> lutadoresExistentes = lutadorRepository.findAll();
        if (!(lutadoresExistentes.isEmpty())){
            return new RequestResult<>(lutadoresExistentes);
        }
        return new RequestResult().error("Não foram encontrados lutadores.");
    }
}
