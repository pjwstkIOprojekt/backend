package com.example.io_backend.dto.Eta;

import lombok.Data;

@Data
public class EtaDto {
    public EtaDto(Double travelDistance, Double travelDuration) {
        this.travelDistance = travelDistance;
        this.travelDuration = travelDuration;
    }

    private Double travelDistance;
    private Double travelDuration;
}
