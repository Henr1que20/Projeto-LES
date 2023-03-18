package com.projeto.les.livraria.service;

import com.projeto.les.livraria.controllers.dto.*;
import com.projeto.les.livraria.model.Cliente;
import com.projeto.les.livraria.model.Endereco;
import com.projeto.les.livraria.model.Telefone;
import com.projeto.les.livraria.model.Usuario;
import com.projeto.les.livraria.repo.ClienteRepository;
import com.projeto.les.livraria.repo.UsuarioRepository;
import com.projeto.les.livraria.service.exceptions.EmailException;
import com.projeto.les.livraria.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO insert(ClienteDTO dto) {

        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        Optional<Cliente> emailExist = clienteRepository.findByEmail(dto.getEmail());

        if(emailExist.isPresent()){
            throw new EmailException("Email ja cadastrado");
        }

        Cliente cliente = new Cliente();
        copyDtoToEntity(dto, cliente, usuario);

        cliente = clienteRepository.save(cliente);

        return new ClienteDTO(cliente);

    }

    private void copyDtoToEntity(ClienteDTO dto, Cliente entity, Usuario usuario) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setGenero(dto.getGenero());
        entity.setUsuario(usuario);
        entity.setEmail(dto.getEmail());
    }

    @Transactional
    public ClienteUpdateDTO atualizar(final Long id, final ClienteUpdateDTO dto) {
        try{
            Cliente cliente = clienteRepository.getOne(id);
            cliente.setNome(dto.getNome());
            cliente.setDataNascimento(dto.getDataNascimento());
            cliente.setCpf(dto.getCpf());
            cliente.setGenero(dto.getGenero());
            cliente = clienteRepository.save(cliente);
            return new ClienteUpdateDTO(cliente);

        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id não encontrado " + id);
        }
    }

    @Transactional(readOnly = true)
    public ClienteUpdateDTO buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return new ClienteUpdateDTO(cliente);
    }

    @Transactional(readOnly = true)
    public List<ClienteDTO> buscarCliente(ClienteFindDTO clienteDTO) {
        List<Cliente> clientes = clienteRepository.findAll(clienteDTO.toSpec());

        if (clientes.isEmpty()){
            throw new ResourceNotFoundException("Cliente não encontrado");
        }

        return clientes.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
    }
}
