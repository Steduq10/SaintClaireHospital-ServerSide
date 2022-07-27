package com.sofkau.SaintClaireHospital.controller;

import com.sofkau.SaintClaireHospital.dto.PatientMedicalSpecialtyDTO;
import com.sofkau.SaintClaireHospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class MedicalSpecialtyController {
    @Autowired
    private PatientService medicalSpecialty;

    @GetMapping("/medical-specialty")
    public List<PatientMedicalSpecialtyDTO> getAllPatientMedicalSpecial(){
        return medicalSpecialty.getAllPatientMedicalSpecialty();
    }
}
