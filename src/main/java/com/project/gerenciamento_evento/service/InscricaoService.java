package com.project.gerenciamento_evento.service;

import com.project.gerenciamento_evento.dto.InscricaoDTO;
import com.project.gerenciamento_evento.entity.Inscricao;
import com.project.gerenciamento_evento.entity.User;
import com.project.gerenciamento_evento.repository.InscricaoRepository;
import com.project.gerenciamento_evento.repository.userRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final userRepository userRepository;

    public List<Inscricao> findAll() {
        return inscricaoRepository.findAll();
    }

    public Inscricao createInscricao(InscricaoDTO dto){
        User user = userRepository.findById(dto.participanteId())
                .orElseThrow(()-> new EntityNotFoundException("Participante não encontrado"));

        if(inscricaoRepository.existsByParticipanteId(dto.participanteId())){
            throw new IllegalArgumentException("Participante já inscrito");
        }

        Inscricao inscricao = new Inscricao();
        inscricao.setParticipante(user);
        inscricao.setDataInscricao(LocalDate.now());

        return inscricaoRepository.save(inscricao);
    }

}
