package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.Victim;
import com.example.io_backend.repository.VictimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VictimService {

    private final VictimRepository victimRepository;

    public List<Victim> getVictims() {
        return victimRepository.findAll();
    }

    public Victim getVictimById(Long id) {
        return victimRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that id"));
    }

    public Victim addVictim(Victim victim) {
        return victimRepository.save(victim);
    }

    public void updateVictim(Victim victim, Long id) {
        var v = victimRepository.findById(id).orElseThrow(() -> new NotFoundException("Victim Not Found"));
        v.setId(victim.getId());
        v.setDocumentId(victim.getDocumentId());
        v.setDocumentName(victim.getDocumentName());
        v.setName(victim.getName());
        v.setSurname(victim.getSurname());
        v.setMedicalInfo(victim.getMedicalInfo());

        victimRepository.save(v);
    }

    public void deleteVictim(Long id) {
        var v = victimRepository.findById(id).orElseThrow(() -> new NotFoundException("Victim Not Found"));
        victimRepository.delete(v);
    }
}
