package com.br.joaoptgaino.jwtservice.dtos;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RoleToUserDto {
    @NotNull(message = "{validator.invalid.null}")
    private String username;

    @NotNull(message = "{validator.invalid.null}")
    private String roleName;
}
