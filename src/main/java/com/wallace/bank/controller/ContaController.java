package com.wallace.bank.controller;

import com.wallace.bank.domain.model.conta.Conta;
import com.wallace.bank.domain.model.conta.ContaDTO;
import com.wallace.bank.domain.model.conta.ContaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var conta = contaRepository.getReferenceById(id);
        return ResponseEntity.ok(new ContaDTO(conta));
    }

    @GetMapping
    public ResponseEntity<Stream<ContaDTO>> listar(){
        var contas = contaRepository.findAllByAtivaTrue().stream().map(ContaDTO::new);
        return ResponseEntity.ok(contas);
    }

    @PostMapping
    @Transactional
    public ResponseEntity inserir(@RequestBody ContaDTO dados){
        var conta = new Conta(dados);
        contaRepository.save(conta);
        return ResponseEntity.ok(conta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable Long id){
        var conta = contaRepository.getReferenceById(id);
        conta.excluir();
        return ResponseEntity.noContent().build();
    }
}
