package com.fatec.springbootdungeonsanddragons.controller;

import com.fatec.springbootdungeonsanddragons.entity.Feiticeiro;
import com.fatec.springbootdungeonsanddragons.entity.Lutador;
import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.service.FeiticeiroService;
import com.fatec.springbootdungeonsanddragons.service.LutadorService;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/lutador")
public class LutadorController {

    @Autowired
    private LutadorService lutadorService;

    @PostMapping("/addLutador")
    public RequestResult addLutador(@RequestBody Lutador lutador){
        return lutadorService.cadastrarLutador(lutador);
    }

    @GetMapping("/lutadores")
    public RequestResult listAllLutadores(){
        return lutadorService.listarLutadores();
    }

    @GetMapping("/lutador/{id}")
    public RequestResult findLutadorById(@PathVariable Long id){
        return lutadorService.buscarLutadorPorId(id);
    }

    @GetMapping("/lutadores/{name}")
    public RequestResult findLutadorByName(@PathVariable String nome){
        return lutadorService.buscarLutadorPorNome(nome);
    }

    @PutMapping("/update")
    public RequestResult updateLutador(Long id, Usuario usuario, String nome, String raca, String classe,
                                       Integer nivel, String antecedente, Integer forca,
                                       Integer destreza, Integer constituicao, Integer inteligencia,
                                       Integer sabedoria, Integer carisma,
                                       Integer dadosSuperioridade){
        return lutadorService.editarLutador(id, usuario, nome, raca, classe, nivel, antecedente, forca,
                destreza, constituicao, inteligencia, sabedoria, carisma, dadosSuperioridade);
    }

    @DeleteMapping("/delete/{id}")
    public RequestResult deleteLutador(@PathVariable Long id){
        return lutadorService.removerLutador(id);
    }
}
