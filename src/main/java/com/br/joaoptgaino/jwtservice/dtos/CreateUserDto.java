package com.br.joaoptgaino.jwtservice.dtos;

import com.br.joaoptgaino.jwtservice.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    @NotNull(message = "{validator.invalid.null}")
    private String name;

    @NotNull(message = "{validator.invalid.null}")
    @Email(message = "must be an email")
    private String username;

    @NotNull(message = "{validator.invalid.null}")
    private String password;

    @NotNull(message = "{validator.invalid.null}")
    private Collection<Role> roles = new ArrayList<>();
}
