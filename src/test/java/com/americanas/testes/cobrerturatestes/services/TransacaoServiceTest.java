package com.americanas.testes.cobrerturatestes.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.model.Pessoa;
import com.americanas.testes.cobrerturatestes.repository.LivroRepository;
import com.americanas.testes.cobrerturatestes.repository.PessoaRepository;
import com.americanas.testes.cobrerturatestes.repository.TransacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransacaoServiceTest {

    @InjectMocks
    private TransacaoService transacaoService;

    @Mock
    private TransacaoRepository transacaoRepository;

    @Mock
    private LivroRepository livroRepository;

    @Mock
    private PessoaRepository pessoaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transacaoService = new TransacaoService(transacaoRepository, livroRepository, pessoaRepository);
    }

    @Test
    void testVerificarSaldoTrue() {
        Pessoa pessoa = new Pessoa(1L, "Marcus", "23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", BigDecimal.valueOf(1000.00));
        BigDecimal valorVenda = BigDecimal.valueOf(500.0);
        boolean resultado = transacaoService.verificarSaldo(pessoa, valorVenda);
        assertTrue(resultado);
    }

    @Test
    void testVerificarSaldoFalse() {
        Pessoa pessoa = new Pessoa(1L, "Marcus", "23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", BigDecimal.valueOf(1000.00));
        BigDecimal valorVenda = BigDecimal.valueOf(1500.0);
        boolean resultado = transacaoService.verificarSaldo(pessoa, valorVenda);
        assertFalse(resultado);
    }

    @Test
    void testVerificarSaldoComSaldoMaiorQueValorVenda() {
        Pessoa pessoa = new Pessoa(1L, "Marcus", "23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", BigDecimal.valueOf(1000.00));
        assertTrue(transacaoService.verificarSaldo(pessoa, BigDecimal.valueOf(150.0)));
    }

    @Test
    void testVerificarSaldoComSaldoMenorQueValorVenda() {
        Pessoa pessoa = new Pessoa(1L, "Marcus", "23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", BigDecimal.valueOf(1000.00));
        assertFalse(transacaoService.verificarSaldo(pessoa, BigDecimal.valueOf(1500.0)));
    }

    @Test
    void testEfetivarVendaComSaldoSuficiente() {
        Pessoa pessoa = new Pessoa(1L, "Marcus", "23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", BigDecimal.valueOf(1000.00));
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(1L, "A Bíblia Sagrada", "Ed. 28ª",
                "Versão King James", BigDecimal.valueOf(380.00), 30));
        livros.add(new Livro(2L, "O Alto da Compadecida", "Ed. 5ª",
                "Ariano Suassuna", BigDecimal.valueOf(30.00), 10));
        assertTrue(transacaoService.efetivarVenda(pessoa, livros));
        assertEquals(BigDecimal.valueOf(590.00), pessoa.getSaldo());
    }

    @Test
    void testEfetivarVendaComSaldoInsuficiente() {
        Pessoa pessoa = new Pessoa(1L, "Marcus", "23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", BigDecimal.valueOf(1000.00));
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(1L, "A Bíblia Sagrada", "Ed. 28ª",
                "Versão King James", BigDecimal.valueOf(380.00), 30));
        livros.add(new Livro(2L, "O Alto da Compadecida", "Ed. 5ª",
                "Ariano Suassuna", BigDecimal.valueOf(3000.00), 10));

        assertFalse(transacaoService.efetivarVenda(pessoa, livros));
        assertEquals(BigDecimal.valueOf(1000.00), pessoa.getSaldo());
    }
}
