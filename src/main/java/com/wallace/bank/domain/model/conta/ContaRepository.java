package com.wallace.bank.domain.model.conta;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Collection<Conta> findAllByAtivaTrue();
}
