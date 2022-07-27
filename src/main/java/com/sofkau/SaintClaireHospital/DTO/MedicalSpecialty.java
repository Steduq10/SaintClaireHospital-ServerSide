package com.sofkau.SaintClaireHospital.DTO;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medical_specialty")
@Data
public class MedicalSpecialty {

    private String name;
    private String physicianCharge;

    @Autowired
    private Patient patient;



}
