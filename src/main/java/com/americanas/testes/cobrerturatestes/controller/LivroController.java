package com.americanas.testes.cobrerturatestes.controller;

import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> salvarLivro(@RequestBody Livro livro) {
        Livro livroSalvo = livroService.salvarLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        Livro livroEncontrado = livroService.buscarLivroPorId(id);
        return ResponseEntity.ok(livroEncontrado);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {
        List<Livro> livros = livroService.listarLivros();
        return ResponseEntity.ok(livros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        livro.setId(id);
        Livro livroAtualizado = livroService.atualizarLivro(livro);
        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLivro(@PathVariable Long id) {
        livroService.excluirLivro(id);
        return ResponseEntity.noContent().build();
    }
}
