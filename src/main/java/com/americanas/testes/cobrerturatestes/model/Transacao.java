package com.americanas.testes.cobrerturatestes.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;


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

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", dataHora=" + momento +
                ", comprador=" + comprador +
                ", livro=" + livro +
                '}';
    }

}

