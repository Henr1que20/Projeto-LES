package com.projeto.les.livraria.controllers;

import com.projeto.les.livraria.controllers.dto.CartaoCreditoDTO;
import com.projeto.les.livraria.controllers.dto.EnderecoDTO;
import com.projeto.les.livraria.model.CartaoCredito;
import com.projeto.les.livraria.service.CartaoCreditoService;
import com.projeto.les.livraria.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/cartoes")
public class CartaoDeCreditoController {

    @Autowired
    private CartaoCreditoService cartaoCreditoService;

    @PostMapping(value = "/{id}")
    @ApiOperation(value = "Cadastrar um novo cartão para um cliente")
    public ResponseEntity<CartaoCreditoDTO> insert(@RequestBody CartaoCreditoDTO dto, @PathVariable Long id) {
        dto = cartaoCreditoService.insert(dto, id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
