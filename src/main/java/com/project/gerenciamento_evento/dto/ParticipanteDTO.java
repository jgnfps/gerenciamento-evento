package com.project.gerenciamento_evento.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ParticipanteDTO (
        Long id,

        @NotBlank(message = "Nome é obrigatório")
        @Size (min = 3, max = 20, message = "o nome deve ter entre 3 e 20 caracteres")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "Telefone é obrigatório")
        String telefone
){
}
