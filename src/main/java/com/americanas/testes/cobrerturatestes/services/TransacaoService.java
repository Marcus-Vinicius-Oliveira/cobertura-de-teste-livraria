package com.americanas.testes.cobrerturatestes.services;


import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.model.Pessoa;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TransacaoService {

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

}

