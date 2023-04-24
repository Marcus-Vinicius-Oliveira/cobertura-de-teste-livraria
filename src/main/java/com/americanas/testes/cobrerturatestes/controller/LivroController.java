package com.americanas.testes.cobrerturatestes.controller;


import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable Long id){
        Livro livro = livroService.buscarLivro(id);
//        Livro l1 = new Livro(1L,"Vinicius","Ed.2","Vini",10.00, 1);
//
//        return ResponseEntity.ok().body(l1);
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

