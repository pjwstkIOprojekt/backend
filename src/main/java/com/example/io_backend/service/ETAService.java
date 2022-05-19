package com.example.io_backend.service;

import com.example.io_backend.dto.Eta.EtaDto;
import com.example.io_backend.dto.Eta.LocationDto;
import com.example.io_backend.model.pojo.Example;
import com.example.io_backend.model.pojo.ResourceSet;
import com.example.io_backend.model.pojo.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ETAService {

    public List<EtaDto> getEtaOfAmbulance(LocationDto... locationDtos) {

        StringBuilder ori = new StringBuilder();
        StringBuilder dest = new StringBuilder();

        for (int i = 0; i < locationDtos.length; i++) {
            if (i == locationDtos.length - 1) {
                ori.append(locationDtos[i].getLongitudeOrigin()).append(",").append(locationDtos[i].getLatitudeOrigin());
                dest.append(locationDtos[i].getLongitudeDestination()).append(",").append(locationDtos[i].getLatitudeDestination());
            } else {
                ori.append(locationDtos[i].getLongitudeOrigin()).append(",").append(locationDtos[i].getLatitudeOrigin()).append(";");
                dest.append(locationDtos[i].getLongitudeDestination()).append(",").append(locationDtos[i].getLatitudeDestination()).append(";");
            }
        }
        String origin = ori.toString();
        String destination = dest.toString();

        final String uri = "https://dev.virtualearth.net/REST/v1/Routes/DistanceMatrix?origins=" +
                origin + "&destinations=" + destination +
                "&travelMode=driving&key=ApXfwO8CZQfb3y0gD-V-ggTupBBpd9TpI4ZANtNYnX6ygslOOZHu9rjLt88-0UQg";

        RestTemplate restTemplate = new RestTemplate();
        Example response = restTemplate.getForObject(uri, Example.class);

        List<ResourceSet> rep = response.getResourceSets();
        List<Result> travelDuration = rep.get(0).getResources().get(0).getResults().stream().toList();
        List<EtaDto> etaDtos = travelDuration.stream().map(e -> new EtaDto(e.getTravelDistance(), e.getTravelDuration() * 0.8)).distinct().collect(Collectors.toList());

        return etaDtos;
    }
}
