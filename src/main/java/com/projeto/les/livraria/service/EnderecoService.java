package com.projeto.les.livraria.service;

import com.projeto.les.livraria.controllers.dto.EnderecoDTO;

public interface EnderecoService {
    EnderecoDTO insert(final EnderecoDTO dto, final Long id);
}
