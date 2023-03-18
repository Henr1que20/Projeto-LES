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

    @GetMapping(value = "/{email}")
    @ApiOperation(value = "Busca um usuario pelo Email")
    public ResponseEntity<UsuarioDTO> findByEmail(@PathVariable String email) {
        UsuarioDTO dto = service.findByEmail(email);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/inativar/{email}")
    @ApiOperation(value = "Inativa um usuario per email")
    public ResponseEntity<Void> desativarUsuario(@PathVariable String email){
        service.inativar(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/atualizar/senha/{email}")
    @ApiOperation(value = "Atualizar senha")
    public ResponseEntity<Void> atualizarSenha(@PathVariable String email, UsuarioUpdateDTO dto){
        service.atualizar(email, dto);
        return ResponseEntity.ok().build();
    }
}
