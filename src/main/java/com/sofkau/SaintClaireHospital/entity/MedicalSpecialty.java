package com.sofkau.SaintClaireHospital.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;

import javax.persistence.*;

@Entity
@Table(name = "medical_specialty")
@Data
public class MedicalSpecialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String physicianCharge;

    @Autowired
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    private Location location;

}
