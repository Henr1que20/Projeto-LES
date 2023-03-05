package com.projeto.les.livraria.controllers;

import com.projeto.les.livraria.controllers.dto.EnderecoDTO;
import com.projeto.les.livraria.service.EnderecoService;
import com.projeto.les.livraria.service.impl.EnderecoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping(value = "/{id}")
    @ApiOperation(value = "Cadastrar um novo endereço para um cliente")
    public ResponseEntity<EnderecoDTO> insert(@RequestBody EnderecoDTO dto, @PathVariable Long id) {
        dto = enderecoService.insert(dto, id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
