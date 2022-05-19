package com.example.io_backend.dto.Eta;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@NotNull
public class LocationDto {

    private String longitudeOrigin;
    private String latitudeOrigin;
    private String longitudeDestination;
    private String latitudeDestination;

}

