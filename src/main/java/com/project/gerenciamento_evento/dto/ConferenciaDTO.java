package com.project.gerenciamento_evento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ConferenciaDTO(
        Long id,

        @NotBlank(message = "O título é obrigatório")
        String titulo,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "A data é obrigatória")
        LocalDate dataConferencia,

        @NotBlank(message = "O local é obrigatório")
        String local
) {}
