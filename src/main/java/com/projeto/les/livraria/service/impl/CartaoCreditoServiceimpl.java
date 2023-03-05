package com.projeto.les.livraria.service.impl;

import com.projeto.les.livraria.controllers.dto.CartaoCreditoDTO;
import com.projeto.les.livraria.model.CartaoCredito;
import com.projeto.les.livraria.model.Cliente;
import com.projeto.les.livraria.repo.CartaoCreditoRepository;
import com.projeto.les.livraria.repo.ClienteRepository;
import com.projeto.les.livraria.repo.EnderecoRepository;
import com.projeto.les.livraria.service.CartaoCreditoService;
import com.projeto.les.livraria.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartaoCreditoServiceimpl implements CartaoCreditoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;

    @Override
    @Transactional
    public CartaoCreditoDTO insert(CartaoCreditoDTO dto, Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        CartaoCredito cartaoCredito = copiarDtoParaEntidade(dto, cliente);

        cartaoCredito = cartaoCreditoRepository.save(cartaoCredito);

        return new CartaoCreditoDTO(cartaoCredito);
    }

    private static CartaoCredito copiarDtoParaEntidade(CartaoCreditoDTO dto, Cliente cliente) {
        CartaoCredito cartaoCredito = new CartaoCredito();
        cartaoCredito.setBandeira(dto.getBandeira());
        cartaoCredito.setPreferencial(dto.isPreferencial());
        cartaoCredito.setCodigoSeguranca(dto.getCodigoSeguranca());
        cartaoCredito.setNomeImpressoCartao(dto.getNomeImpressoCartao());
        cartaoCredito.setNumeroCartao(dto.getNumeroCartao());
        cartaoCredito.setCliente(cliente);
        return cartaoCredito;
    }
}
