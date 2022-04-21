package com.example.io_backend.service;

import com.example.io_backend.dto.UserMedicalInfoDto;
import com.example.io_backend.dto.converter.UserMedicalInfoConverter;
import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.MedicalInfo;
import com.example.io_backend.model.User;
import com.example.io_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final MedicalInfoService medicalInfoService;
    UserMedicalInfoConverter converter;


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that id"));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void updateUser(User user, Integer id) {
        var p = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        p.setId(user.getId());
        p.setLastName(user.getLastName());
        p.setFirstName(user.getFirstName());
        p.setBirthDate(user.getBirthDate());
        p.setMedicalInfo(user.getMedicalInfo());
        p.setPhone(user.getPhone());
        p.setBandCode(user.getBandCode());

        userRepository.save(p);
    }

    public void deleteUser(Integer id) {
        var p = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
        userRepository.delete(p);
    }

    public UserMedicalInfoDto addUserMedicalInfo(Integer id, MedicalInfo medicalInfo) {
        if(medicalInfo != null) {
            User user = this.getUserById(id);
            medicalInfoService.addMedicalInfo(medicalInfo);
            user.setMedicalInfo(medicalInfo);
            return converter.entityToDto(user);
        }
        return null;
    }

    public UserMedicalInfoDto updateUserMedicalInfo(Integer id, MedicalInfo medicalInfo ) {
        User user = this.getUserById(id);
        medicalInfoService.updateMedicalInfo(medicalInfo,user.getMedicalInfo().getId());
        return converter.entityToDto(user);
    }



}
