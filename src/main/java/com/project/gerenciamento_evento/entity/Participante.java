package com.project.gerenciamento_evento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_participante")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    @OneToMany(mappedBy = "participante")
    private List<Inscricao> inscricoes;

    @OneToMany(mappedBy = "participante")
    private List<Pagamento> pagamentos;

    @OneToMany(mappedBy = "participante")
    private List<Certificado> certificados;
}
