package com.project.gerenciamento_evento.repository;

import com.project.gerenciamento_evento.entity.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    boolean existsByParticipanteId(Long participanteId);
}
