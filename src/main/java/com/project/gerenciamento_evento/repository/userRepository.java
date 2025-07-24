package com.project.gerenciamento_evento.repository;

import com.project.gerenciamento_evento.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
