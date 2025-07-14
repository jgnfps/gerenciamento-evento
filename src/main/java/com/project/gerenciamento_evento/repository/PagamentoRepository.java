package com.project.gerenciamento_evento.repository;

import com.project.gerenciamento_evento.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
