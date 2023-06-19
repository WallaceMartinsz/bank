package com.wallace.bank.domain.model.conta;

import com.wallace.bank.domain.model.usuario.Usuario;

public record ContaDTO(Long id, Usuario usuario, TipoConta tipoConta, boolean ativa) {
    public ContaDTO(Conta conta){
        this(conta.getId(), conta.getUsuario(), conta.getTipo(), conta.isAtiva());
    }
}
