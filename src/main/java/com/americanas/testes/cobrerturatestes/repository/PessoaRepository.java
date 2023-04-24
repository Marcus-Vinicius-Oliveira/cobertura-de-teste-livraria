package com.americanas.testes.cobrerturatestes.repository;

import com.americanas.testes.cobrerturatestes.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
