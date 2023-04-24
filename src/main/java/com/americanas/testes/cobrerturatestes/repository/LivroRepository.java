package com.americanas.testes.cobrerturatestes.repository;

import com.americanas.testes.cobrerturatestes.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
