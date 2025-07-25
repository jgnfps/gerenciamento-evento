package com.project.gerenciamento_evento.repository;

import com.project.gerenciamento_evento.entity.Conferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConferenciaRepository extends JpaRepository<Conferencia, Long> {

    Optional<Conferencia> findByTitulo(String titulo);
}
