package com.sofkau.SaintClaireHospital.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Medical_specialty")
@Table(name = "medical_specialty")
@Data
public class MedicalSpecialty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String physicianCharge;

    //private Long fkDNI;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    List<Patient> patientList = new ArrayList<>();


    public MedicalSpecialty addPatient(Patient patient){
        this.patientList.add(patient);
        return this;
    }

}
