package com.fatec.springbootdungeonsanddragons.controller;

import com.fatec.springbootdungeonsanddragons.entity.Usuario;
import com.fatec.springbootdungeonsanddragons.service.UsuarioService;
import com.fatec.springbootdungeonsanddragons.utils.RequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/addUsuario")
    public RequestResult addUsuario(@RequestBody Usuario usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping("/usuarios")
    public RequestResult listAllUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/byId/{id}")
    public RequestResult findUsuarioById(@PathVariable Long id){
        return usuarioService.buscarUsuarioPorId(id);
    }

    @GetMapping("/byUsername/{nome}")
    public RequestResult findUsuarioByName(@PathVariable String nome){
        return usuarioService.buscarUsuarioPorNome(nome);
    }

    @PutMapping("/update")
    public RequestResult updateUsuario(Long id, String nomeUsuario, String senha, String nomeExibicao){
        return usuarioService.editarUsuario(id, nomeUsuario, senha, nomeExibicao);
    }

    @DeleteMapping("/delete/{id}")
    public RequestResult deleteUsuario(@PathVariable Long id){
        return usuarioService.removerUsuario(id);
    }

}
