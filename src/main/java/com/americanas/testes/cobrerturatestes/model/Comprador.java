package com.americanas.testes.cobrerturatestes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
public class Comprador extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToMany
    @JoinTable(name = "compra",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_livro"))
    private List<Livro> livros = new ArrayList<>();

//    public Comprador(){
//
//    }
//
//    public Comprador(List<Livro> livros) {
//        super();
//        this.livros = livros;
//    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public boolean jaComprou(Livro livro) {
        for (Livro livrosComprados : livros) {
            if (livrosComprados.getId().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }

    public void adicionarLivroComprado(Livro livro) {
        if (livros == null) {
            livros = new ArrayList<>();
        }
        livros.add(livro);
    }


}

