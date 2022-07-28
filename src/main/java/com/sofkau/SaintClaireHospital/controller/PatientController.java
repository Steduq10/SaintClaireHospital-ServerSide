package com.sofkau.SaintClaireHospital.controller;

import com.sofkau.SaintClaireHospital.dto.PatientMedicalSpecialtyDTO;
import com.sofkau.SaintClaireHospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    public List<PatientMedicalSpecialtyDTO> getAllPatientMedicalSpecial(){
        return patientService.getAllPatientMedicalSpecialty();
    }
}
