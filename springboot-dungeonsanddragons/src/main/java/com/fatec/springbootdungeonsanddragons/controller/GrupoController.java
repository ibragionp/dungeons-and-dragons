package com.fatec.springbootdungeonsanddragons.controller;

import com.fatec.springbootdungeonsanddragons.entity.Grupo;
import com.fatec.springbootdungeonsanddragons.service.GrupoService;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/grupo")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @PostMapping("/addGrupo")
    public RequestResult addGrupo(@RequestBody Grupo grupo){
        return grupoService.cadastrarGrupo(grupo);
    }


    @GetMapping("/grupo/{id}")
    public RequestResult findGrupoById(@PathVariable Long id){
        return grupoService.buscarGrupo(id);
    }


    @DeleteMapping("/delete/{id}")
    public RequestResult deleteGrupo(@PathVariable Long id){
        return grupoService.removerGrupo(id);
    }


}
