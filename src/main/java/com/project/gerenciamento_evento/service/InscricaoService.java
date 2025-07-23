package com.project.gerenciamento_evento.service;

import com.project.gerenciamento_evento.dto.InscricaoDTO;
import com.project.gerenciamento_evento.entity.Inscricao;
import com.project.gerenciamento_evento.entity.Participante;
import com.project.gerenciamento_evento.repository.Eventorepository;
import com.project.gerenciamento_evento.repository.InscricaoRepository;
import com.project.gerenciamento_evento.repository.ParticipanteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final ParticipanteRepository participanteRepository;

    public List<Inscricao> findAll() {
        return inscricaoRepository.findAll();
    }

    public Inscricao createInscricao(InscricaoDTO dto){
        Participante participante = participanteRepository.findById(dto.participanteId())
                .orElseThrow(()-> new EntityNotFoundException("Participante não encontrado"));

        if(inscricaoRepository.existsByParticipanteId(dto.participanteId())){
            throw new IllegalArgumentException("Participante já inscrito");
        }

        Inscricao inscricao = new Inscricao();
        inscricao.setParticipante(participante);
        inscricao.setDataInscricao(LocalDate.now());

        return inscricaoRepository.save(inscricao);
    }

}
