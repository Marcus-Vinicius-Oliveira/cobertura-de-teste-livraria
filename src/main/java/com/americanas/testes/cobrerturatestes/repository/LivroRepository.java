package com.americanas.testes.cobrerturatestes.repository;

import com.americanas.testes.cobrerturatestes.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT l FROM Livro l WHERE l.id = :id AND l.vendido = false")
    Optional<Livro> findByIdAndVendidoFalse(Long id);


}
