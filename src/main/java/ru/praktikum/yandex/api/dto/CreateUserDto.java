package ru.praktikum.yandex.api.dto;

import lombok.*;

@Data
public class CreateUserDto {
    private String email;
    private String password;
    private String name;
}

