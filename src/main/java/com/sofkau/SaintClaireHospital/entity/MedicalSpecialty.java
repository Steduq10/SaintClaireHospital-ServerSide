package com.sofkau.SaintClaireHospital.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;

import javax.persistence.*;

@Entity(name = "Medical_specialty")
@Table(name = "medical_specialty")
@Data
public class MedicalSpecialty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String physicianCharge;

    private Long fkDNI;



}
