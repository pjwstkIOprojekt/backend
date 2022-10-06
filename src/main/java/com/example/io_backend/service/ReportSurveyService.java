package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.ReportSurvey;
import com.example.io_backend.repository.ReportSurveyRepository;
import com.example.io_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReportSurveyService {

    private final ReportSurveyRepository reportSurveyRepository;
    private final UserRepository userRepository;

    public List<ReportSurvey> getSurveysReport() {
        return reportSurveyRepository.findAll();
    }

    public ReportSurvey getSurveysReportById(Integer id){
        return reportSurveyRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that id"));
    }

    public ReportSurvey addReportSurvay(ReportSurvey reportSurvey){
        return reportSurveyRepository.save(reportSurvey);
    }
    public void updateReportSurvey(ReportSurvey reportSurvey, Integer id) {
        var r = reportSurveyRepository.findById(id).orElseThrow(() -> new NotFoundException("Report survey Not found "));
        r.setDate(reportSurvey.getDate());
        r.setBandCode(reportSurvey.getBandCode());
        r.setEmergencyType(reportSurvey.getEmergencyType());
        r.setLocation(reportSurvey.getLocation());
        r.setVictimCount(reportSurvey.getVictimCount());
        r.setDescription(reportSurvey.getDescription());
        r.setVictimBreathing(reportSurvey.getVictimBreathing());
        r.setVictimConscious(reportSurvey.getVictimConscious());
        r.setDescription(reportSurvey.getDescription());
        r.setVictims(reportSurvey.getVictims());
        r.setUser(reportSurvey.getUser());

        reportSurveyRepository.save(r);
    }

    public void deleteReportSurvey(Integer id){
        var r = reportSurveyRepository.findById(id).orElseThrow(() -> new NotFoundException("Report survey Not found "));
        reportSurveyRepository.delete(r);
    }


}
