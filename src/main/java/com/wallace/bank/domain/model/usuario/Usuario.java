package com.wallace.bank.domain.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wallace.bank.domain.model.conta.Conta;
import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double rendaMensal;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private Conta conta;

}
