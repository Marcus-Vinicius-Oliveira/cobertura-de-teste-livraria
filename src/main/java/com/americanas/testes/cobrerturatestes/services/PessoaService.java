package com.americanas.testes.cobrerturatestes.services;

import com.americanas.testes.cobrerturatestes.model.Pessoa;
import com.americanas.testes.cobrerturatestes.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {


    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public void atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        pessoaRepository.findById(id)
                .ifPresent(pessoa -> {
                    pessoa.setNome(pessoaAtualizada.getNome());
                    pessoa.setDataNascimento(pessoaAtualizada.getDataNascimento());
                    pessoa.setCpf(pessoaAtualizada.getCpf());
                    pessoa.setEmail(pessoaAtualizada.getEmail());
                    pessoa.setTelefone(pessoaAtualizada.getTelefone());
                    pessoa.setSaldo(pessoaAtualizada.getSaldo());
                    pessoaRepository.save(pessoa);
                });
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

}
