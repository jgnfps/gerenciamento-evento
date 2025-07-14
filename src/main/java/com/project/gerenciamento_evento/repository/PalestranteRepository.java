package com.project.gerenciamento_evento.repository;

import com.project.gerenciamento_evento.entity.Palestrante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalestranteRepository extends JpaRepository<Palestrante, Long> {
}
