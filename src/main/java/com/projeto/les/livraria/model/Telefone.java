package com.projeto.les.livraria.model;

import com.projeto.les.livraria.controllers.dto.TelefoneDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String telefone;

    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "fk_telefone_cliente"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private Cliente cliente;

    public Telefone(TelefoneDTO dto) {
        this.id = dto.getId();
        this.telefone = dto.getTelefone();
        //this.cliente = dto.
    }
}
