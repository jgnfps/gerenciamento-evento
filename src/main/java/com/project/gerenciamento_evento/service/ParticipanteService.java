package com.project.gerenciamento_evento.service;

import com.project.gerenciamento_evento.dto.ParticipanteDTO;
import com.project.gerenciamento_evento.entity.Certificado;
import com.project.gerenciamento_evento.entity.Inscricao;
import com.project.gerenciamento_evento.entity.Pagamento;
import com.project.gerenciamento_evento.entity.Participante;
import com.project.gerenciamento_evento.repository.ParticipanteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParticipanteService {

    @Autowired
    private final ParticipanteRepository participanteRepository;


    public List<Participante> findAll(){
        return participanteRepository.findAll();
    }

    public Participante findById(Long id){
        Optional<Participante> participante = participanteRepository.findById(id);
        return participante.orElseThrow(() -> new RuntimeException("Participante não encontrado com o ID: " + id));
    }

    public Participante createParticipante(ParticipanteDTO dto){
        Participante participante = new Participante();
        participante.setNome(dto.nome());
        participante.setEmail(dto.email());
        participante.setTelefone(dto.telefone());
        return participanteRepository.save(participante);
    }

    public void delete(Long id){
        participanteRepository.deleteById(id);
    }

    public List<Inscricao> getInscricoes(Long participanteId){
        Participante participante = findById(participanteId);
        return participante.getInscricoes();
    }

    public List<Pagamento> getPagamentos(Long participanteId){
        Participante participante = findById(participanteId);
        return participante.getPagamentos();
    }

    public List<Certificado> getCertificados(Long participanteId){
        Participante participante = findById(participanteId);
        return participante.getCertificados();
    }

    public Participante update(Long id, ParticipanteDTO dto){
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Participante não encontrado com o ID: " + id));

        participante.setNome(dto.nome());
        participante.setEmail(dto.email());
        participante.setTelefone(dto.telefone());

        return participanteRepository.save(participante);
    }
}
