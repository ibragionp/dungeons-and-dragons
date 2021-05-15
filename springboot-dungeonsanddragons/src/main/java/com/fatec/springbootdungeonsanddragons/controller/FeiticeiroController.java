package com.fatec.springbootdungeonsanddragons.controller;

import com.fatec.springbootdungeonsanddragons.entity.Feiticeiro;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.service.FeiticeiroService;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/feiticeiro")
public class FeiticeiroController {

    @Autowired
    private FeiticeiroService feiticeiroService;

    @PostMapping("/addFeiticeiro")
    public RequestResult addFeiticeiro(@RequestBody Feiticeiro feiticeiro){
        return feiticeiroService.cadastrarFeiticeiro(feiticeiro);
    }

    @GetMapping("/feiticeiros")
    public RequestResult listAllFeiticeiros(){
        return feiticeiroService.listarFeiticeiros();
    }

    @GetMapping("/feiticeiro/{id}")
    public RequestResult findFeiticeiroById(@PathVariable Long id){
        return feiticeiroService.buscarFeiticeiroPorId(id);
    }

    @GetMapping("/feiticeiros/{name}")
    public RequestResult findFeiticeiroByName(@PathVariable String nome){
        return feiticeiroService.buscarFeiticeiroPorNome(nome);
    }

    @PutMapping("/update")
    public RequestResult updateFeiticeiro(Long id, Usuario usuario, String nome,
                                          String raca, String classe, Integer nivel, String antecedente,
                                          Integer forca, Integer destreza, Integer constituicao,
                                          Integer inteligencia, Integer sabedoria, Integer carisma,
                                          Integer magiasConhecidas, Integer modificadorHabilidade){
        return feiticeiroService.editarFeiticeiro(id, usuario, nome, raca, classe, nivel, antecedente,
                forca, destreza, constituicao, inteligencia, sabedoria, carisma, magiasConhecidas,
                modificadorHabilidade);
    }

    @DeleteMapping("/delete/{id}")
    public RequestResult deleteFeiticeiro(@PathVariable Long id){
        return feiticeiroService.removerFeiticeiro(id);
    }

}
