package com.br.joaoptgaino.jwtservice.repositories;

import com.br.joaoptgaino.jwtservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
