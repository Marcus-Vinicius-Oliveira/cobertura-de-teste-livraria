package com.americanas.testes.cobrerturatestes.services;


import com.americanas.testes.cobrerturatestes.model.Livro;
import com.americanas.testes.cobrerturatestes.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRespository;

    public Livro salvarLivro(Livro livro){
        return livroRespository.save(livro);
    }

    public Livro buscarLivroPorId(Long id){
        return livroRespository.findById(id)
                .orElseThrow(()-> new RuntimeException("Livro não encontrado"));
    }

    public List<Livro> listarLivros(){
        return livroRespository.findAll();
    }

    public Livro atualizarLivro(Livro livro){
        Livro livroExistente = buscarLivroPorId(livro.getId());
        livroExistente.setNome(livro.getNome());
        livroExistente.setAutor(livro.getAutor());
        livroExistente.setPreco(livro.getPreco());
        livroExistente.setQuantidade(livro.getQuantidade());
        livroExistente.setEdicao(livro.getEdicao());
        return livroRespository.save(livroExistente);
    }

    public void excluirLivro(Long id){
        Livro livro = buscarLivroPorId(id);
        livroRespository.delete(livro);
    }

}

