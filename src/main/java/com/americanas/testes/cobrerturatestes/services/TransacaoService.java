package com.americanas.testes.cobrerturatestes.services;

import com.americanas.testes.cobrerturatestes.exception.CompraDuplicadaException;
import com.americanas.testes.cobrerturatestes.exception.LivroNaoDisponivelException;
import com.americanas.testes.cobrerturatestes.model.Comprador;
import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.model.Pessoa;
import com.americanas.testes.cobrerturatestes.model.Transacao;
import com.americanas.testes.cobrerturatestes.repository.LivroRepository;
import com.americanas.testes.cobrerturatestes.repository.PessoaRepository;
import com.americanas.testes.cobrerturatestes.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransacaoService {


    private final TransacaoRepository transacaoRepository;

    private LivroRepository livroRepository;

    private PessoaRepository pessoaRepository;

    @Transactional
    public Transacao adicionarTransacao(Transacao transacao) {
        transacao.setMomento(Instant.now());
        Pessoa comprador = transacao.getComprador();
        Livro livro = transacao.getLivro();
        BigDecimal valorVenda = transacao.getValorVenda();

        // Verifica se o livro está disponível para venda
        Optional<Livro> livroDisponivel = livroRepository.findByIdAndVendidoFalse(livro.getId());
        if (livroDisponivel.isEmpty()) {
            throw new LivroNaoDisponivelException("O livro " + livro.getNome() + " não está disponível para venda.");
        }

        // Verifica se o comprador já comprou o livro antes
        if (comprador instanceof Comprador && ((Comprador) comprador).jaComprou(livro)) {
            throw new CompraDuplicadaException("O comprador " + comprador.getNome() + " já comprou o livro " + livro.getNome() + " antes.");
        }

        // Registra a transação
        Livro livroVendido = livroDisponivel.get();
        livroVendido.setVendido(true);
        livroRepository.save(livroVendido);
        if (comprador instanceof Comprador) {
            ((Comprador) comprador).adicionarLivroComprado(livroVendido);
        }
        pessoaRepository.save(comprador);
        transacao.setLivro(livroVendido);
        return transacaoRepository.save(transacao);
    }

    public Transacao buscarTransacaoPorId(Long id) {
        return transacaoRepository.findById(id).orElse(null);
    }

    public List<Transacao> buscarTodasTransacoes() {
        return transacaoRepository.findAll();
    }


    public Transacao atualizarTransacao(Long id, Transacao transacaoAtualizada) {
        Transacao transacaoAntiga = buscarTransacaoPorId(id);
        if (transacaoAntiga != null) {
            transacaoAtualizada.setId(id);
            return transacaoRepository.save(transacaoAtualizada);
        }
        return null;
    }

    public void removerTransacao(Long id) {
        transacaoRepository.deleteById(id);
    }

    public boolean verificarSaldo(@NotNull Pessoa pessoa, @NotNull BigDecimal valorVenda) {
        return pessoa.getSaldo().compareTo(valorVenda) >= 0;
    }

    public boolean efetivarVenda(Pessoa pessoa, @NotNull List<Livro> livros) {
        BigDecimal valorVenda = BigDecimal.ZERO;
        for (Livro livro : livros) {
            valorVenda = valorVenda.add(livro.getPreco());
        }
        if (verificarSaldo(pessoa, valorVenda)) {
            pessoa.setSaldo(pessoa.getSaldo().subtract(valorVenda));
            return true;
        } else {
            return false;
        }
    }

}

