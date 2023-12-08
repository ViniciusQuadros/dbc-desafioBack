package com.dbc.desafioback.dtos;

import com.dbc.desafioback.domain.user.UserType;

public record UserDTO(String name, String document, String email, UserType userType) {
}
