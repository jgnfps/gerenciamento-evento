package com.project.gerenciamento_evento.repository;

import com.project.gerenciamento_evento.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
}
