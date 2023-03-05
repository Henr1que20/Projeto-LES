package com.projeto.les.livraria.controllers.dto;

import com.projeto.les.livraria.model.CartaoCredito;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartaoCreditoDTO {

    private Long id;
    private String bandeira;
    private boolean isPreferencial;
    private String codigoSeguranca;
    private String nomeImpressoCartao;
    private String numeroCartao;

    public CartaoCreditoDTO(Long id, String bandeira, boolean isPreferencial, String codigoSeguranca, String nomeImpressoCartao, String numeroCartao) {
        this.id = id;
        this.bandeira = bandeira;
        this.isPreferencial = isPreferencial;
        this.codigoSeguranca = codigoSeguranca;
        this.nomeImpressoCartao = nomeImpressoCartao;
        this.numeroCartao = numeroCartao;
    }

    public CartaoCreditoDTO(CartaoCredito cartaoCredito) {
        this.id = cartaoCredito.getId();
        this.bandeira = cartaoCredito.getBandeira();
        this.isPreferencial = cartaoCredito.isPreferencial();
        this.codigoSeguranca = cartaoCredito.getCodigoSeguranca();
        this.nomeImpressoCartao = cartaoCredito.getNomeImpressoCartao();
        this.numeroCartao = cartaoCredito.getNumeroCartao();
    }
}
