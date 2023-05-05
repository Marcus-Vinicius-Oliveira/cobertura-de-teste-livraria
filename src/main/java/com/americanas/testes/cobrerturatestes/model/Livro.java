package com.americanas.testes.cobrerturatestes.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String edicao;

    private String autor;

    private Double preco;

    private Integer quantidade;

    private Boolean vendido = true;

    @OneToMany(mappedBy = "livro")
    private List<Transacao> transacoes;

    @ManyToMany(mappedBy = "livros")
    private List<Comprador> compradores;

    public Livro(){

    }

    public Livro(Long id, String nome, String edicao,
                 String autor, Double preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.edicao = edicao;
        this.autor = autor;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", edicao='" + edicao + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}

