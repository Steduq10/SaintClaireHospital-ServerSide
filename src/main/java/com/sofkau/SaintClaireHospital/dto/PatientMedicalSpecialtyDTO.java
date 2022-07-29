package com.sofkau.SaintClaireHospital.dto;

import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;

import com.sofkau.SaintClaireHospital.entity.Patient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
public class PatientMedicalSpecialtyDTO {

   // @Autowired
    //private MedicalSpecialty medicalSpecialty;
    //private Patient patient;

    private Long id;

    private String name;

    private String physicianCharge;

    private List<Patient> patientList = new ArrayList<>();

}
