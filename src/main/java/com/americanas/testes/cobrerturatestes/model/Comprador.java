package com.americanas.testes.cobrerturatestes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comprador extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany
    private List<Livro> livros = new ArrayList<>();

    public Comprador(){

    }

    public Comprador(List<Livro> livros) {
        super();
        this.livros = livros;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Comprador{" +
                "livros=" + livros +
                '}';
    }
}

