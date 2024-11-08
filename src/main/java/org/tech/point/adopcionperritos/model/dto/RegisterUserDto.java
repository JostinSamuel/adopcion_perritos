package org.tech.point.adopcionperritos.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterUserDto {
    private String email;
    private String password;
    private String fullName;
    private LocalDateTime createdAt;

}