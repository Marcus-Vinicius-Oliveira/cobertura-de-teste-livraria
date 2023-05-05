package com.americanas.testes.cobrerturatestes.services;

import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.repository.LivroRepository;
import com.americanas.testes.cobrerturatestes.services.LivroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LivroServiceTest {

    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    private LivroService livroService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvarLivro() {
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setNome("A Bíblia Sagrada");
        livro.setAutor("Versão King James");
        livro.setPreco(380.00);
        livro.setQuantidade(30);
        livro.setEdicao("Ed. 28ª");

        when(livroRepository.save(livro)).thenReturn(livro);

        Livro livroSalvo = livroService.salvarLivro(livro);

        assertEquals(livro, livroSalvo);
    }

    @Test
    public void testBuscarLivroPorId() {
        Long id = 1L;
        Livro livro = new Livro();
        livro.setId(id);
        livro.setNome("A Bíblia Sagrada");
        livro.setAutor("Versão King James");
        livro.setPreco(380.00);
        livro.setQuantidade(30);
        livro.setEdicao("Ed. 28ª");

        when(livroRepository.findById(id)).thenReturn(Optional.of(livro));

        Livro livroEncontrado = livroService.buscarLivroPorId(id);

        assertEquals(livro, livroEncontrado);
    }

    @Test
    public void testListarLivros() {
        List<Livro> listaLivros = new ArrayList<>();
        Livro livro1 = new Livro();
        livro1.setId(1L);
        livro1.setNome("A Bíblia Sagrada");
        livro1.setAutor("Versão King James");
        livro1.setPreco(380.00);
        livro1.setQuantidade(30);
        livro1.setEdicao("Ed. 28ª");

        Livro livro2 = new Livro();
        livro2.setId(2L);
        livro2.setNome("O Alto da Compadecida");
        livro2.setAutor("Ariano Suassuna");
        livro2.setPreco(30.00);
        livro2.setQuantidade(10);
        livro2.setEdicao("Ed. 5ª");

        listaLivros.add(livro1);
        listaLivros.add(livro2);

        when(livroRepository.findAll()).thenReturn(listaLivros);

        List<Livro> listaLivrosEncontrados = livroService.listarLivros();

        assertEquals(listaLivros, listaLivrosEncontrados);
    }

    @Test
    public void testAtualizarLivro() {
        Long id = 1L;
        Livro livro = new Livro();
        livro.setId(id);
        livro.setNome("A Bíblia Sagrada");
        livro.setAutor("Versão King James");
        livro.setPreco(380.00);
        livro.setQuantidade(30);
        livro.setEdicao("Ed. 28ª");

        Livro livroAtualizado = new Livro();
        livroAtualizado.setId(id);
        livroAtualizado.setNome("Padrões de Projetos");
        livroAtualizado.setAutor("Erich Gamma");
        livroAtualizado.setPreco(93.01);
        livroAtualizado.setQuantidade(15);
        livroAtualizado.setEdicao("Ed. 4a");

        when(livroRepository.findById(livro.getId())).thenReturn(Optional.of(livro));
        when(livroRepository.save(livro)).thenReturn(livroAtualizado);

        Livro livroRetornado = livroService.atualizarLivro(livroAtualizado);

        assertEquals(livroAtualizado, livroRetornado);
    }

    @Test
    public void testExcluirLivro() {
        // cria um mock de Livro
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setNome("O Senhor dos Anéis");
        livro.setAutor("J.R.R. Tolkien");
        livro.setPreco(50.0);
        livro.setQuantidade(10);
        livro.setEdicao("1ª edição");

        // quando o método buscarLivroPorId() for chamado, retorna o livro criado acima
        when(livroRepository.findById(1L)).thenReturn(java.util.Optional.of(livro));

        // chama o método excluirLivro() passando o ID do livro criado acima
        livroService.excluirLivro(1L);

        // verifica se o método delete() foi chamado com o livro criado acima como argumento
        verify(livroRepository).delete(livro);
    }

}



