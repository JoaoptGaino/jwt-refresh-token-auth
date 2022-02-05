package com.br.joaoptgaino.jwtservice.repositories;

import com.br.joaoptgaino.jwtservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByName(String name);
}
