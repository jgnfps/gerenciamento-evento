package com.project.gerenciamento_evento.entity;

import com.project.gerenciamento_evento.enums.userType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String biografia; // usado só para palestrante, pode ficar null para participante

    @Enumerated(EnumType.STRING)
    private userType usertype;

    @OneToMany(mappedBy = "participante")
    private List<Inscricao> inscricoes; // só faz sentido para PARTICIPANTE

    @OneToMany(mappedBy = "participante")
    private List<Pagamento> pagamentos;  // só para PARTICIPANTE

    @OneToMany(mappedBy = "participante")
    private List<Certificado> certificados; // só para PARTICIPANTE
}



