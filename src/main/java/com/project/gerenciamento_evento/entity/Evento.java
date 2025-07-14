package com.project.gerenciamento_evento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private LocalDate dataEvento;

    private String local;

    @OneToMany(mappedBy = "evento")
    private List<Pagamento> pagamentos;

    @OneToMany(mappedBy = "evento")
    private List<Certificado> certificados;
}
