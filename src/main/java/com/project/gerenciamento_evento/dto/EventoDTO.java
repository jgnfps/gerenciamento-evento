package com.project.gerenciamento_evento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EventoDTO(
        @NotBlank(message = "Id é obrigatório")
        Long id,

        @NotBlank(message = "o titulo é obrigatório")
        String titulo,

        @NotBlank(message = "a descricao é obrigatória")
        String descricao,

        @NotBlank(message = "o local é obrigatório")
        String local,

        @NotNull(message = "A data é obrigatória")
        LocalDate dataEvento
) {
}
