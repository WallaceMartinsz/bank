package com.wallace.bank.domain.model.conta;

import com.wallace.bank.domain.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoConta tipo;

    public Conta(ContaDTO dados) {
        this.id = dados.id();
        this.usuario = dados.usuario();
        this.tipo = dados.tipoConta();
    }
}
