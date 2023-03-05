package com.projeto.les.livraria.model;

import com.projeto.les.livraria.model.enums.TipoCupom;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_cupom")
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double valor;
    private String codigo;
    private TipoCupom tipoCupom;

    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "fk_cupom_cliente"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private Cliente cliente;

}
