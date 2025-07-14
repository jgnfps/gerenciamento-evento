package com.project.gerenciamento_evento.dto;

import jakarta.validation.constraints.NotBlank;

public record PalestranteDTO(
        Long id,

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "A biografia é obrigatória")
        String biografia
) {
}
