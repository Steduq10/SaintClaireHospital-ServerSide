package com.sofkau.SaintClaireHospital.dto;

import com.sofkau.SaintClaireHospital.entity.Patient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class PatientMedicalSpecialtyDTO {
    private Long patientID;
    private String name;
    private String physicianCharge;

    @Autowired
    private Patient patient;
}
