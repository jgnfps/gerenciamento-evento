package com.project.gerenciamento_evento.dto;

import com.project.gerenciamento_evento.enums.userType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(

        Long id,

        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email deve ser válido")
        String email,

        @Size(max = 20, message = "Telefone deve ter no máximo 20 caracteres")
        String telefone,

        @Size(max = 500, message = "Biografia deve ter no máximo 500 caracteres")
        String biografia,

        @NotNull(message = "Tipo de usuário é obrigatório")
        userType userType

) {
}
