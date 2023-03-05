package com.projeto.les.livraria.service;

import com.projeto.les.livraria.controllers.dto.ClienteDTO;
import com.projeto.les.livraria.controllers.dto.ClienteUpdateDTO;
import com.projeto.les.livraria.controllers.dto.EnderecoDTO;
import com.projeto.les.livraria.controllers.dto.TelefoneDTO;
import com.projeto.les.livraria.model.Cliente;
import com.projeto.les.livraria.model.Endereco;
import com.projeto.les.livraria.model.Telefone;
import com.projeto.les.livraria.model.Usuario;
import com.projeto.les.livraria.repo.ClienteRepository;
import com.projeto.les.livraria.repo.UsuarioRepository;
import com.projeto.les.livraria.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
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
        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found")));

        Cliente cliente = new Cliente();
        copyDtoToEntity(dto, cliente, usuario);

        cliente = clienteRepository.save(cliente);

        return new ClienteDTO(cliente);

    }


    private void copyDtoToEntity(ClienteDTO dto, Cliente entity, Optional<Usuario> usuario) {

        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setGenero(dto.getGenero());
        entity.setUsuario(usuario.get());

        List<Endereco> enderecos = new ArrayList<>();

        if(dto.getEnderecos() != null && !dto.getEnderecos().isEmpty()){
            enderecos.stream().map(x -> new Endereco((EnderecoDTO) dto.getEnderecos())).collect(Collectors.toList());

            entity.setEnderecos(enderecos);
        }

        List<Telefone> telefones = new ArrayList<>();

        if (dto.getTelefones() != null && !dto.getTelefones().isEmpty()){
            telefones.stream().map(x -> new Telefone((TelefoneDTO) dto.getTelefones())).collect(Collectors.toList());

            entity.setTelefones(telefones);
        }
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
    public Page<ClienteDTO> buscarCliente(Long id, String nome, LocalDate dataNascimento, LocalDate cpf, LocalDate genero, Pageable pageable) {
        Page<Cliente> clientes = clienteRepository.findAll(pageable);
        return clientes.map(x -> new ClienteDTO(x));
    }
}
