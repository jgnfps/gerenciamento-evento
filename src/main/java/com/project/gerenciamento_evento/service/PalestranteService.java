package com.project.gerenciamento_evento.service;

import com.project.gerenciamento_evento.dto.PalestranteDTO;
import com.project.gerenciamento_evento.entity.Palestrante;
import com.project.gerenciamento_evento.repository.PalestranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PalestranteService {

    @Autowired
    private final PalestranteRepository palestranteRepository;

    public List<Palestrante> findAll() {
        return palestranteRepository.findAll();
    }

    public Palestrante createPalestrante(PalestranteDTO dto) {
        Palestrante palestrante = new Palestrante();
        palestrante.setNome(dto.nome());
        palestrante.setBiografia(dto.biografia());
        return palestranteRepository.save(palestrante);
    }

    public void delete(Long id) {
        palestranteRepository.deleteById(id);
    }
}
