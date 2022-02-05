package com.br.joaoptgaino.jwtservice.services;

import com.br.joaoptgaino.jwtservice.configs.PasswordEncoderConfiguration;
import com.br.joaoptgaino.jwtservice.dtos.CreateRoleDto;
import com.br.joaoptgaino.jwtservice.dtos.CreateUserDto;
import com.br.joaoptgaino.jwtservice.models.Role;
import com.br.joaoptgaino.jwtservice.models.User;
import com.br.joaoptgaino.jwtservice.repositories.RoleRepository;
import com.br.joaoptgaino.jwtservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("User not found");
            throw new UsernameNotFoundException("User not found.");
        }
        log.info("User {} found", username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(CreateUserDto userDto) {
        log.info("Saving new user {} ", userDto.getName());

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        User user = modelMapper.map(userDto, User.class);

        return userRepository.save(user);
    }

    @Override
    public Role saveRole(CreateRoleDto roleDto) {
        log.info("Saving new {} role", roleDto.getName());

        Role role = modelMapper.map(roleDto, Role.class);

        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {} ", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
