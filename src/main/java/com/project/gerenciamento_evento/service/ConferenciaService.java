package com.project.gerenciamento_evento.service;

import com.project.gerenciamento_evento.dto.ConferenciaDTO;
import com.project.gerenciamento_evento.entity.Conferencia;
import com.project.gerenciamento_evento.repository.ConferenciaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ConferenciaService {
    private final ConferenciaRepository conferenciaRepository;

    public List<Conferencia> findAll() {
        return conferenciaRepository.findAll();
    }

    public Conferencia findByTitulo(String titulo) {
        return conferenciaRepository.findByTitulo(titulo)
                .orElseThrow(()-> new EntityNotFoundException("Conferência não encontrada com o título: " + titulo));
    }

    public Conferencia createConferencia(ConferenciaDTO dto) {
        if(conferenciaRepository.findByTitulo(dto.titulo()).isPresent()) {
            throw new IllegalArgumentException("Já existe uma conferência com esse título: " + dto.titulo());
        }
        if(dto.dataConferencia().isBefore(LocalDate.now())){
            throw new IllegalArgumentException("A data da conferência deve ser futura");
        }

        Conferencia conferencia = new Conferencia();
        conferencia.setTitulo(dto.titulo());
        conferencia.setDescricao(dto.descricao());
        conferencia.setDataConferencia(dto.dataConferencia());
        conferencia.setLocal(dto.local());

        return conferenciaRepository.save(conferencia);
    }

    public void deleteById(Long id) {
        conferenciaRepository.deleteById(id);
    }

    public Conferencia updateConferencia(Long id, ConferenciaDTO dto) {
        Conferencia conferencia = conferenciaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Conferência não encontrada com o id: " + id));

        conferencia.setTitulo(dto.titulo());
        conferencia.setDescricao(dto.descricao());
        conferencia.setDataConferencia(dto.dataConferencia());
        conferencia.setLocal(dto.local());

        return conferenciaRepository.save(conferencia);
    }
}
