package com.example.io_backend.controller;

import com.example.io_backend.dto.AllergiesDto;
import com.example.io_backend.dto.BloodTypeDto;
import com.example.io_backend.dto.ChronicDiseaseDto;
import com.example.io_backend.dto.MedicalInfoDto;
import com.example.io_backend.model.MedicalInfo;
import com.example.io_backend.model.enums.BloodType;
import com.example.io_backend.service.MedicalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/medicalInfo")
@RequiredArgsConstructor
public class MedicalInfoController {

    private final MedicalInfoService medicalInfoService;

    @GetMapping("")
    public List<MedicalInfo> getAll() {
        return medicalInfoService.getMedicalInfo();
    }

    @GetMapping("/{id}")
    public MedicalInfo getById(@PathVariable Long id) {
        return medicalInfoService.getMedicalInfoById(id);
    }

    @PostMapping("")
    public MedicalInfo add(@RequestBody MedicalInfo medicalInfo){
        return medicalInfoService.addMedicalInfo(medicalInfo);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody MedicalInfo medicalInfo,@PathVariable Long id){
         medicalInfoService.updateMedicalInfo(medicalInfo,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        medicalInfoService.deleteMedicalInfo(id);
    }

    @PutMapping("/blood/{id}")
    public ResponseEntity<MedicalInfoDto> updateBloodtype(@PathVariable Long id, @RequestBody BloodTypeDto bloodType) {
        return new ResponseEntity<>(medicalInfoService.updateBloodType(id, bloodType), HttpStatus.OK);
    }

    @PutMapping("/chronic/{id}")
    public ResponseEntity<MedicalInfoDto> updateChronicDisease(@PathVariable Long id,@RequestBody ChronicDiseaseDto chronicDisease) {
        return  new ResponseEntity<>(medicalInfoService.updateChronicDiseases(id, chronicDisease),HttpStatus.OK);
    }

    @PutMapping("/allergies/{id}")
    public ResponseEntity<MedicalInfoDto> updateAllergies(@PathVariable Long id,@RequestBody AllergiesDto ... allergies) {
        return new ResponseEntity<>(medicalInfoService.updateAllergies(id, allergies),HttpStatus.OK);
    }

}
