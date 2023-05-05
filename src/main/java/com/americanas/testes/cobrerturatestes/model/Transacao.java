package com.americanas.testes.cobrerturatestes.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


@Entity
public class Transacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant momento;

    @ManyToOne
    @JoinColumn(name = "id_comprador")
    private Pessoa comprador;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    private Double valorVenda;

    public Transacao(){

    }

    public Transacao(Long id, Instant momento,
                     Pessoa comprador, Livro livro, Double valorVenda) {
        this.id = id;
        this.momento = momento;
        this.comprador = comprador;
        this.livro = livro;
        this.valorVenda = valorVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Pessoa getComprador() {
        return comprador;
    }

    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Double getValorVenda(){
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda){
        this.valorVenda = valorVenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(id, transacao.id) && Objects.equals(momento, transacao.momento) && Objects.equals(comprador, transacao.comprador) && Objects.equals(livro, transacao.livro) && Objects.equals(valorVenda, transacao.valorVenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, momento, comprador, livro, valorVenda);
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", momento=" + momento +
                ", comprador=" + comprador +
                ", livro=" + livro +
                ", valorVenda=" + valorVenda +
                '}';
    }
}

