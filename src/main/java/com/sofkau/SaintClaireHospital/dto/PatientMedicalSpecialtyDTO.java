package com.sofkau.SaintClaireHospital.dto;

import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class PatientMedicalSpecialtyDTO {

    @Autowired
    private MedicalSpecialty medicalSpecialty;

    private Long patientID;
    private String name;
    private int age;
    private Long DNI;
    private Long numberOfAppointments =0L;
}
