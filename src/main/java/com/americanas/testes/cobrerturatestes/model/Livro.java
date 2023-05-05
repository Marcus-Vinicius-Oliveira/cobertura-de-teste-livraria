package com.americanas.testes.cobrerturatestes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String edicao;

    private String autor;

    private BigDecimal preco;

    private Integer quantidade;

    private Boolean vendido = false;

    @OneToMany(mappedBy = "livro")
    private List<Transacao> transacoes;

    @ManyToMany(mappedBy = "livros")
    private List<Comprador> compradores;

    public Livro(){

    }

    public Livro(Long id, String nome, String edicao,
                 String autor, BigDecimal preco, Integer quantidade) {
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id) && Objects.equals(nome, livro.nome) && Objects.equals(edicao, livro.edicao) && Objects.equals(autor, livro.autor) && Objects.equals(preco, livro.preco) && Objects.equals(quantidade, livro.quantidade) && Objects.equals(vendido, livro.vendido) && Objects.equals(transacoes, livro.transacoes) && Objects.equals(compradores, livro.compradores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, edicao, autor, preco, quantidade, vendido, transacoes, compradores);
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

