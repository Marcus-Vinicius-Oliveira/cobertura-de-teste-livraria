package com.americanas.testes.cobrerturatestes.controller;

import com.americanas.testes.cobrerturatestes.model.Transacao;
import com.americanas.testes.cobrerturatestes.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarTransacaoPorId(@PathVariable int id) {
        Transacao transacao = transacaoService.buscarTransacaoPorId(id);
        if (transacao != null) {
            return ResponseEntity.ok(transacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Transacao> adicionarTransacao(@RequestBody Transacao transacao) {
        transacaoService.adicionarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarTransacao(@PathVariable int id, @RequestBody Transacao transacaoAtualizada) {
        transacaoService.atualizarTransacao(id, transacaoAtualizada);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTransacao(@PathVariable int id) {
        transacaoService.removerTransacao(id);
        return ResponseEntity.noContent().build();
    }
}
