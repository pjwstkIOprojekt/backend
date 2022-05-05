package com.example.io_backend.model.dto.request;


import com.example.io_backend.model.enums.BloodType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateEmergencyRequest {
    private Short dangerRating;
    private String description;
    private Boolean breathing;
    private Boolean conscious;
    private BloodType bloodType;
}
