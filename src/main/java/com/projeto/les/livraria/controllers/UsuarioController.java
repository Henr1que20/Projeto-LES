package com.projeto.les.livraria.controllers;

import com.projeto.les.livraria.controllers.dto.UsuarioDTO;
import com.projeto.les.livraria.controllers.dto.UsuarioInsertDTO;
import com.projeto.les.livraria.controllers.dto.UsuarioUpdateDTO;
import com.projeto.les.livraria.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @ApiOperation(value = "Cadastrar um novo usuario")
    public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioInsertDTO dto){
        UsuarioDTO newUser = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Busca um usuario pelo Id")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        UsuarioDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/inativar/{id}")
    @ApiOperation(value = "Inativa um usuario pelo Id")
    public ResponseEntity<Void> desativarUsuario(@PathVariable Long id){
        service.inativar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/atualizar/senha/{id}")
    @ApiOperation(value = "Atualizar senha")
    public ResponseEntity<Void> atualizarSenha(@PathVariable Long id, UsuarioUpdateDTO dto){
        service.atualizar(id, dto);
        return ResponseEntity.ok().build();
    }
}
