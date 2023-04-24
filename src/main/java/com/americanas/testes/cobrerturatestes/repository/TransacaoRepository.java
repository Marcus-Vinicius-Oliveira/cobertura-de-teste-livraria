package com.americanas.testes.cobrerturatestes.repository;

import com.americanas.testes.cobrerturatestes.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
