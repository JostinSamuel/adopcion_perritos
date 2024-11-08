package org.tech.point.adopcionperritos.model.dto;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;
    private String password;
}