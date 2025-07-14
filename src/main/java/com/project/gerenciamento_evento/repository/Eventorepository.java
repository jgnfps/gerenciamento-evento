package com.project.gerenciamento_evento.repository;

import com.project.gerenciamento_evento.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Eventorepository extends JpaRepository<Evento, Long> {
}
