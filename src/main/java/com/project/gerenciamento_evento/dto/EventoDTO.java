package com.project.gerenciamento_evento.dto;

import jakarta.validation.constraints.NotBlank;

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

        @NotBlank(message = "A data é obrigatória")
        LocalDate dataEvento
) {
}
