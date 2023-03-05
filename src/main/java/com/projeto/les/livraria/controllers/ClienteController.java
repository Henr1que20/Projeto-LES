package com.projeto.les.livraria.controllers;

import com.projeto.les.livraria.controllers.dto.ClienteDTO;
import com.projeto.les.livraria.controllers.dto.ClienteUpdateDTO;
import com.projeto.les.livraria.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

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
    @ApiOperation(value = "Busca paginada de clientes")
    public ResponseEntity<Page<ClienteDTO>> buscarCliente(
            @RequestParam(value = "id", defaultValue = "0") Long id,
            @RequestParam(value = "nome", defaultValue = "null") String nome,
            @RequestParam(value = "dataNascimento", defaultValue = "null") LocalDate dataNascimento,
            @RequestParam(value = "cpf", defaultValue = "null") LocalDate cpf,
            @RequestParam(value = "genero", defaultValue = "null") LocalDate genero,
            Pageable pageable){
        Page<ClienteDTO> dto = clienteService.buscarCliente(id, nome, dataNascimento, cpf, genero, pageable);
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
