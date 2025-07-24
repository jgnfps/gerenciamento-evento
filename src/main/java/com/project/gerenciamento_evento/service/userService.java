package com.project.gerenciamento_evento.service;

import com.project.gerenciamento_evento.dto.UserDTO;
import com.project.gerenciamento_evento.entity.User;
import com.project.gerenciamento_evento.enums.userType;
import com.project.gerenciamento_evento.repository.userRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class userService {
    private final userRepository userRepository;

    public User createUser(UserDTO dto) {

        if(dto.userType() == userType.PALESTRANTE && dto.biografia() == null || dto.biografia().isBlank()){
            throw new IllegalArgumentException("Biografia é obrigatória para palestrante");
        }

        User user = new User();
        user.setId(dto.id());
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setTelefone(dto.telefone());
        user.setBiografia(dto.biografia());
        user.setUsertype(dto.userType());

        return userRepository.save(user);
    }

    public User findByEmail(String email) {
       return userRepository.findByEmail(email)
                .orElseThrow(()-> new EntityNotFoundException("usuário não encontrado com o email: " + email));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, UserDTO dto) {

        if(dto.userType() == userType.PALESTRANTE && dto.biografia() == null || dto.biografia().isBlank()){
            throw new IllegalArgumentException("Biografia é obrigatória para palestrante");
        }

        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado com o id: " + id));


        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setTelefone(dto.telefone());
        user.setBiografia(dto.biografia());
        user.setUsertype(dto.userType());

        return userRepository.save(user);
    }
}
