package com.americanas.testes.cobrerturatestes.services;

import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.model.Pessoa;
import com.americanas.testes.cobrerturatestes.model.Transacao;
import com.americanas.testes.cobrerturatestes.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class TransacaoService {
    private List<Transacao> transacoes;


    private final TransacaoRepository transacaoRepository;

    public boolean verificarSaldo(@NotNull Pessoa pessoa, Double valorVenda) {
        return pessoa.getSaldo() >= valorVenda;
    }

    public boolean efetivarVenda(Pessoa pessoa, @NotNull List<Livro> livros) {
        Double valorVenda = 0.0;
        for (Livro livro : livros) {
            valorVenda += livro.getPreco();
        }
        if (verificarSaldo(pessoa, valorVenda)) {
            pessoa.setSaldo(pessoa.getSaldo() - valorVenda);
            return true;
        } else {
            return false;
        }
    }

    public Transacao buscarTransacaoPorId(int id) {
        for (Transacao transacao : transacoes) {
            if (transacao.getId() == id) {
                return transacao;
            }
        }
        return null;
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void atualizarTransacao(int id, Transacao transacaoAtualizada) {
        Transacao transacaoAntiga = buscarTransacaoPorId(id);
        if (transacaoAntiga != null) {
            int index = transacoes.indexOf(transacaoAntiga);
            transacoes.set(index, transacaoAtualizada);
        }
    }

    public void removerTransacao(int id) {
        Transacao transacao = buscarTransacaoPorId(id);
        if (transacao != null) {
            transacoes.remove(transacao);
        }
    }

}

