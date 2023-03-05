package com.projeto.les.livraria.service.impl;


import com.projeto.les.livraria.controllers.dto.EnderecoDTO;
import com.projeto.les.livraria.model.Cidade;
import com.projeto.les.livraria.model.Cliente;
import com.projeto.les.livraria.model.Endereco;
import com.projeto.les.livraria.model.Estado;
import com.projeto.les.livraria.repo.ClienteRepository;
import com.projeto.les.livraria.repo.EnderecoRepository;
import com.projeto.les.livraria.service.EnderecoService;
import com.projeto.les.livraria.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Override
    @Transactional
    public EnderecoDTO insert(final EnderecoDTO dto, final Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        Endereco endereco = mapperDtoForEntity(dto, cliente);

        endereco = enderecoRepository.saveAndFlush(endereco);
        return new EnderecoDTO(endereco);
    }

    private Endereco mapperDtoForEntity(EnderecoDTO dto, Cliente cliente) {
        Endereco endereco = new Endereco();
        endereco.setNome(dto.getNome());
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setTipoLogradouro(dto.getTipoLogradouro());
        endereco.setBairro(dto.getBairro());
        endereco.setNumero(dto.getNumero());
        endereco.setCep(dto.getCep());
        endereco.setComplemento(dto.getComplemento());
        endereco.setPais(dto.getPais());

        Cidade cidade = new Cidade();
        cidade.setNome(dto.getNomeCidade());

        Estado estado = new Estado();
        estado.setNome(dto.getNomeEstado());
        estado.setUf(dto.getUf());
        cidade.setEstado(estado);
        endereco.setCidade(cidade);


        endereco.setDescricao(dto.getDescricao());
        endereco.setCliente(cliente);

        return endereco;
    }
}
