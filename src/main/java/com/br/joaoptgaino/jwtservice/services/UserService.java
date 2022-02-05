package com.br.joaoptgaino.jwtservice.services;

import com.br.joaoptgaino.jwtservice.dtos.CreateRoleDto;
import com.br.joaoptgaino.jwtservice.dtos.CreateUserDto;
import com.br.joaoptgaino.jwtservice.models.Role;
import com.br.joaoptgaino.jwtservice.models.User;

import java.util.List;

public interface UserService {
    User saveUser(CreateUserDto user);
    Role saveRole(CreateRoleDto role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
