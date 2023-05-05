package com.americanas.testes.cobrerturatestes;

import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.model.Pessoa;
import com.americanas.testes.cobrerturatestes.model.Transacao;
import com.americanas.testes.cobrerturatestes.repository.LivroRepository;
import com.americanas.testes.cobrerturatestes.repository.PessoaRepository;
import com.americanas.testes.cobrerturatestes.repository.TransacaoRepository;
import com.americanas.testes.cobrerturatestes.services.TransacaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", 1000.00);
        Double valorVenda = 500.0;
        boolean resultado = transacaoService.verificarSaldo(pessoa, valorVenda);
        assertTrue(resultado);
    }

    @Test
    void testVerificarSaldoFalse() {
        Pessoa pessoa = new Pessoa(1L, "Marcus", "23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", 1000.00);
        Double valorVenda = 1500.0;
        boolean resultado = transacaoService.verificarSaldo(pessoa, valorVenda);
        assertFalse(resultado);
    }

    @Test
    void testVerificarSaldoComSaldoMaiorQueValorVenda() {
        Pessoa pessoa = new Pessoa(1L, "Marcus", "23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", 1000.00);
        assertTrue(transacaoService.verificarSaldo(pessoa, 150.0));

    }

    @Test
    void testVerificarSaldoComSaldoMenorQueValorVenda() {
        Pessoa pessoa = new Pessoa(1L, "Marcus", "23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", 1000.00);
        assertFalse(transacaoService.verificarSaldo(pessoa, 1500.0));
    }

    @Test
    void testEfetivarVendaComSaldoSuficiente() {
        Pessoa pessoa = new Pessoa(1L, "Marcus", "23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", 1000.00);
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(1L, "A Bíblia Sagrada", "Ed. 28ª",
                "Versão King James", 380.00,30));
        livros.add(new Livro(2L,"O Alto da Compadecida", "Ed. 5ª",
                "Ariano Suassuna", 30.00, 10));
        assertTrue(transacaoService.efetivarVenda(pessoa, livros));
        assertEquals(590.0, pessoa.getSaldo());
    }

    @Test
    void testEfetivarVendaComSaldoInsuficiente() {
        Pessoa pessoa = new Pessoa(1L, "Marcus", "23/03/1987",
                "124.998.954-20", "mvoliveirajus@gmail.com", "21964285551", 1000.00);
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(1L, "A Bíblia Sagrada", "Ed. 28ª",
                "Versão King James", 380.00,30));
        livros.add(new Livro(2L,"O Alto da Compadecida", "Ed. 5ª",
                "Ariano Suassuna", 3000.00, 10));
        assertFalse(transacaoService.efetivarVenda(pessoa, livros));
        assertEquals(1000.0, pessoa.getSaldo());
    }


}
