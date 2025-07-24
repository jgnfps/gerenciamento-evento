package com.project.gerenciamento_evento.dto;

import jakarta.validation.constraints.NotBlank;

public record InscricaoDTO(@NotBlank(message = "O id é obrigatório") Long participanteId) {
}
