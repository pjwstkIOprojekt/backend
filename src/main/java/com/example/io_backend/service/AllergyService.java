package com.example.io_backend.service;

import com.example.io_backend.dto.AllergiesDto;
import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.Allergy;
import com.example.io_backend.repository.AllergyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class AllergyService {

    private final AllergyRepository allergyRepository;
    private final ModelMapper modelMapper;

    public AllergiesDto getAllergyById(Long allergyId){
        return modelMapper.map(allergyRepository.findById(allergyId).orElseThrow(()-> new NotFoundException("No record with that ID")),AllergiesDto.class);}

    public Allergy addAllergy(AllergiesDto allergiesDto){
       return allergyRepository.save(modelMapper.map(allergiesDto, Allergy.class));
    }

    public Allergy updateAllergy(Long allergyId, AllergiesDto allergiesDto) {
        var a = modelMapper.map(this.getAllergyById(allergyId), Allergy.class);
        a.setId(allergiesDto.getId());
        a.setAllergyName(allergiesDto.getAllergyName());
        a.setAllergyType(allergiesDto.getAllergyType());
        a.setAdditionalInfo(allergiesDto.getAdditionalInfo());
        return allergyRepository.save(a);
    }

    public void deleteAllergy(Long allergyId) {
        var a = modelMapper.map(this.getAllergyById(allergyId), Allergy.class);
        allergyRepository.delete(a);
    }


}
