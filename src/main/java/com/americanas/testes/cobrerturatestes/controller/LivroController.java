package com.americanas.testes.cobrerturatestes.controller;


import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> ListarLivros(){
        List<Livro> list = livroService.listarLivros();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id){
        Livro livro = livroService.buscarLivroPorId(id);
        return ResponseEntity.ok(livro);
    }

//    @PostMapping
//    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
//        Livro novoLivro = livroService.salvarLivro(livro);
//        return ResponseEntity.ok(novoLivro);
//    }
//
////    @PutMapping("/{id}")
////    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
////        Livro livroAtualizado = livroService.atualizarLivro(id, livro);
////        return ResponseEntity.ok(livroAtualizado);
////    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> excluirLivro(@PathVariable Long id) {
//        livroService.excluirLivro(id);
//        return ResponseEntity.noContent().build();
//    }
}

