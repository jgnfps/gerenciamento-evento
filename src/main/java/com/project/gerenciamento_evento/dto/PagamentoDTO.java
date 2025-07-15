package com.project.gerenciamento_evento.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagamentoDTO (
        Long id,
        String eventoTitulo,
        String participanteNome,
        BigDecimal valor,
        LocalDate dataPagamento
){}
