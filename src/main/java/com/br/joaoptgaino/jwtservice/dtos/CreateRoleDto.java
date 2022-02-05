package com.br.joaoptgaino.jwtservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleDto {

    @NotNull(message = "{validator.invalid.null}")
    private String name;
}
