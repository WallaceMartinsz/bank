package com.wallace.bank.domain.model.conta;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wallace.bank.domain.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@Getter
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

    private boolean ativa;

    public Conta(ContaDTO dados) {
        this.ativa = true;
        this.id = dados.id();
        this.usuario = dados.usuario();
        this.tipo = dados.tipoConta();
    }

    public void excluir(){
        this.ativa = false;
    }
}
