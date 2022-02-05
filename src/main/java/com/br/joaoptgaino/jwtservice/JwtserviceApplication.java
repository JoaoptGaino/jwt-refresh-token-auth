package com.br.joaoptgaino.jwtservice;

import com.br.joaoptgaino.jwtservice.dtos.CreateRoleDto;
import com.br.joaoptgaino.jwtservice.dtos.CreateUserDto;
import com.br.joaoptgaino.jwtservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class JwtserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new CreateRoleDto("USER"));
            userService.saveRole(new CreateRoleDto("MANAGER"));
            userService.saveRole(new CreateRoleDto("ADMIN"));
            userService.saveRole(new CreateRoleDto("SUPER_ADMIN"));

            userService.saveUser(new CreateUserDto("João","joaoptgaino","joao321",new ArrayList<>()));
            userService.saveUser(new CreateUserDto("Riri","riri","riri321",new ArrayList<>()));
            userService.saveUser(new CreateUserDto("João 2","joaoptgaino 2 ","joao321",new ArrayList<>()));
            userService.saveUser(new CreateUserDto("Riri 2","riri 2","riri321",new ArrayList<>()));


            userService.addRoleToUser("joaoptgaino","USER");
            userService.addRoleToUser("joaoptgaino","ADMIN");
            userService.addRoleToUser("joaoptgaino","SUPER_ADMIN");
            userService.addRoleToUser("riri","USER");
            userService.addRoleToUser("riri","ADMIN");

        };
    }
}
