package com.americanas.testes.cobrerturatestes.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Transacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    @ManyToOne
    private Pessoa comprador;

    @ManyToOne
    private Livro livro;

    private Double valorVenda;

    public Transacao(){

    }

    public Transacao(Long id, LocalDateTime dataHora,
                     Pessoa comprador, Livro livro, Double valorVenda) {
        this.id = id;
        this.dataHora = dataHora;
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
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
                ", dataHora=" + dataHora +
                ", comprador=" + comprador +
                ", livro=" + livro +
                '}';
    }

}

