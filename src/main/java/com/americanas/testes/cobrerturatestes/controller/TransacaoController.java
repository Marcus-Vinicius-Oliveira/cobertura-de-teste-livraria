package com.americanas.testes.cobrerturatestes.controller;

import com.americanas.testes.cobrerturatestes.model.Comprador;
import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.model.Pessoa;
import com.americanas.testes.cobrerturatestes.model.Transacao;
import com.americanas.testes.cobrerturatestes.services.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
@AllArgsConstructor
public class TransacaoController {
    private final TransacaoService transacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarTransacaoPorId(@PathVariable Long id) {
        Transacao transacao = transacaoService.buscarTransacaoPorId(id);
        if (transacao != null) {
            return ResponseEntity.ok(transacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Transacao> buscarTodasTransacoes() {
        return transacaoService.buscarTodasTransacoes();
    }

    @PostMapping
    public ResponseEntity<Transacao> adicionarTransacao(@RequestBody Transacao transacao) {
        transacaoService.adicionarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizarTransacao(@PathVariable Long id, @RequestBody Transacao transacaoAtualizada) {
        Transacao transacao = transacaoService.atualizarTransacao(id, transacaoAtualizada);
        if (transacao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTransacao(@PathVariable Long id) {
        transacaoService.removerTransacao(id);
        return ResponseEntity.noContent().build();
    }
}
