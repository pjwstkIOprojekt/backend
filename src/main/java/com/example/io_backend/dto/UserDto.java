package com.example.io_backend.dto;

import com.example.io_backend.model.MedicalInfo;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LocalDate birthDate;
    private String phone;
    private String bandCode;
    private MedicalInfo medicalInfo;
}