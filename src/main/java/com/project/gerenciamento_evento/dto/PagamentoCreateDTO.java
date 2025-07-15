package com.project.gerenciamento_evento.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagamentoCreateDTO(
        @NotNull(message = "Id do evento é obrigatório")
        Long eventoId,

        @NotNull(message = "ID do participante é obrigatório")
        Long participanteId,

        @NotNull(message = "Valor é obrigatório")
        @Positive(message = "O valor deve ser positivo")
        BigDecimal valor,

        @NotNull(message = "Data de pagamento é obrigatória")
        LocalDate dataPagamento
) {
}
