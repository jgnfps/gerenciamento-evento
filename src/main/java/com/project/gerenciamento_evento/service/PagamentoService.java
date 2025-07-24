package com.project.gerenciamento_evento.service;


import com.project.gerenciamento_evento.dto.PagamentoCreateDTO;
import com.project.gerenciamento_evento.dto.PagamentoDTO;
import com.project.gerenciamento_evento.entity.Evento;
import com.project.gerenciamento_evento.entity.Pagamento;
import com.project.gerenciamento_evento.repository.Eventorepository;
import com.project.gerenciamento_evento.repository.PagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PagamentoService {


    private final PagamentoRepository pagamentoRepository;
    private final Eventorepository eventorepository;
    private final ParticipanteRepository participanteRepository;

    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

    public Pagamento findById(Long id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pagamento não encontrado com o ID: " + id));

    }

    public Pagamento createPagamento(PagamentoCreateDTO dto){
        Evento evento = eventorepository.findById(dto.eventoId())
                .orElseThrow(()-> new RuntimeException("Evento não encontrado com o ID: " + dto.eventoId()));

        Participante participante = participanteRepository.findById(dto.participanteId())
                .orElseThrow(()-> new RuntimeException("Participante não encontrado com o ID: " + dto.participanteId()));

        Pagamento pagamento = new Pagamento();

        pagamento.setEvento(evento);
        pagamento.setParticipante(participante);
        pagamento.setValor(dto.valor());
        pagamento.setDataPagamento(dto.dataPagamento());

        return pagamentoRepository.save(pagamento);
    }

    public void delete(Long id) {
        Pagamento pagamento = findById(id);
        pagamentoRepository.delete(pagamento);
    }

    public PagamentoDTO toDTO(Pagamento pagamento){
        return new PagamentoDTO(
          pagamento.getId(),
          pagamento.getEvento().getTitulo(),
          pagamento.getParticipante().getNome(),
          pagamento.getValor(),
          pagamento.getDataPagamento()
        );
    }

}
