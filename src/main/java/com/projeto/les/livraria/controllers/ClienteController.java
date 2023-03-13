package com.projeto.les.livraria.controllers;

import com.projeto.les.livraria.controllers.dto.ClienteDTO;
import com.projeto.les.livraria.controllers.dto.ClienteUpdateDTO;
import com.projeto.les.livraria.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Busba um cliente pelo id")
    public ResponseEntity<ClienteUpdateDTO> buscarClientePorId(@PathVariable Long id){
        ClienteUpdateDTO dto = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    @ApiOperation(value = "Busca paginada de clientes teste")
    public ResponseEntity<String> buscarCliente(ClienteDTO clienteDTO, Pageable pageable){
        String dto = clienteService.buscarCliente(clienteDTO, pageable);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    @ApiOperation(value = "Cadastrar um novo cliente")
    public ResponseEntity<ClienteDTO> insert(@RequestBody ClienteDTO dto){
        dto = clienteService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualizar cliente")
    public ResponseEntity<ClienteUpdateDTO> atualizar(@RequestBody ClienteUpdateDTO dto, @PathVariable Long id){
        dto = clienteService.atualizar(id, dto);
        return ResponseEntity.ok().body(dto);
    }


}
