package com.example.io_backend.dto;

import com.example.io_backend.model.enums.BloodType;
import lombok.Data;

import java.util.List;

@Data
public class MedicalInfoDto {
    private Long id;
    private BloodType bloodType;
    private String chronicDiseases;
    private List<AllergiesDto> allergies;
}
