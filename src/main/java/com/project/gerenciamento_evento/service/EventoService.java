package com.project.gerenciamento_evento.service;

import com.project.gerenciamento_evento.dto.EventoDTO;
import com.project.gerenciamento_evento.entity.Evento;
import com.project.gerenciamento_evento.repository.CertificadoRepository;
import com.project.gerenciamento_evento.repository.Eventorepository;
import com.project.gerenciamento_evento.repository.PagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventoService {

    private final Eventorepository eventorepository;
    private final PagamentoRepository pagamentoRepository;
    private final CertificadoRepository CertificadoRepository;
    private final CertificadoRepository certificadoRepository;

    public List<Evento> findAll() {
        return eventorepository.findAll();
    }

    public Evento findById(Long id) {
        return eventorepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Evento não encontrado com o id: " + id));
    }

    public Evento createEvento(EventoDTO dto) {
        Evento evento = new Evento();

        evento.setId(dto.id());
        evento.setTitulo(dto.titulo());
        evento.setDescricao(dto.descricao());
        evento.setDataEvento(dto.dataEvento());

        return eventorepository.save(evento);
    }

    public void deleteEvento(Long id) {
        eventorepository.deleteById(id);
    }
    

}
