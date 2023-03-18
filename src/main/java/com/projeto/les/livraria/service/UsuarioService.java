package com.projeto.les.livraria.service;

import com.projeto.les.livraria.controllers.dto.UsuarioDTO;
import com.projeto.les.livraria.controllers.dto.UsuarioInsertDTO;
import com.projeto.les.livraria.controllers.dto.UsuarioUpdateDTO;
import com.projeto.les.livraria.model.Role;
import com.projeto.les.livraria.model.Usuario;
import com.projeto.les.livraria.repo.RoleRepository;
import com.projeto.les.livraria.repo.UsuarioRepository;
import com.projeto.les.livraria.service.exceptions.EmailException;
import com.projeto.les.livraria.service.exceptions.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Log4j2
@Service
public class UsuarioService {

    private final String USUARIO_INATIVADO = "Usuario inativado";
    private final String ERRO_USUARIO = "Usuario nao encontrado";

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioDTO insert(final UsuarioInsertDTO dto) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(dto.getEmail());

        if(usuario.isPresent()){
            throw new EmailException("User already exists");
        }

        Usuario newUser = new Usuario();
        copyDtoToEntity(dto, newUser);
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        newUser =  usuarioRepository.save(newUser);
        return new UsuarioDTO(newUser);

    }

    private void copyDtoToEntity(UsuarioInsertDTO dto, Usuario entity) {
        Role role = new Role(1L, "ROLE_CLIENTE");
        entity.setEmail(dto.getEmail());
        entity.getRoles().add(role);
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        Usuario entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UsuarioDTO(entity);
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findByEmail(String email) {
        Optional<Usuario> obj = usuarioRepository.findByEmail(email);
        Usuario entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UsuarioDTO(entity);
    }


    @Transactional
    public void inativar(Long id) {
        try {
            Usuario usuario = usuarioRepository.getOne(id);
            usuario.setAtivo(false);
            usuarioRepository.save(usuario);
            log.info("id={}, status={}", id, USUARIO_INATIVADO);
        }
        catch (EntityNotFoundException e){
            log.error("id={}, status={}", id, ERRO_USUARIO);
            throw new ResourceNotFoundException("Id não encontrado");
        }
    }

    @Transactional
    public void atualizar(Long id, UsuarioUpdateDTO dto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));

        if (!passwordEncoder.matches(dto.getPassword(), usuario.getPassword())) {
            usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        usuarioRepository.save(usuario);
    }
}