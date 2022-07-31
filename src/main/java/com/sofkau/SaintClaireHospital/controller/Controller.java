package com.sofkau.SaintClaireHospital.controller;

import com.sofkau.SaintClaireHospital.dto.PatientMedicalSpecialtyDTO;
import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;
import com.sofkau.SaintClaireHospital.entity.Patient;
import com.sofkau.SaintClaireHospital.service.PatientService;
import com.sofkau.SaintClaireHospital.service.PatientServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("hospital/")
@CrossOrigin("*")
public class Controller {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<PatientMedicalSpecialtyDTO> getAllPatientMedicalSpecial(){
        return patientService.getAllPatientMedicalSpecialty();
    }


    @PostMapping("create/specialty")
    public MedicalSpecialty createPatient(@RequestBody MedicalSpecialty medicalSpecialty){
        return patientService.saveSpecialty(medicalSpecialty);
    }

    @PostMapping("create/patient")
    public MedicalSpecialty createMedicalSpecialty(@RequestBody Patient patient){
        return  patientService.savePatient(patient);
    }



    @DeleteMapping("delete/specialty")
    public void deleteMedicalSpecialty(@RequestBody MedicalSpecialty medicalSpecialty){
        patientService.deleteSpecialty(medicalSpecialty);

    }

    

    @PutMapping("update/specialty")
    public MedicalSpecialty updateSpecialty(@RequestBody MedicalSpecialty medicalSpecialty){
        return patientService.updateSpecialty(medicalSpecialty);
    }

    @PutMapping("update/patient")
    public Patient updatePatient(@RequestBody Patient patient){
        return patientService.updatePatient(patient);
    }
}
