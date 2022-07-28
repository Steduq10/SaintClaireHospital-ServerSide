package com.sofkau.SaintClaireHospital.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Patient")
@Table(name = "patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    List<MedicalSpecialty> medicalSpecialtyList = new ArrayList<>();


    //private MedicalSpecialty medicalSpecialty;

    private String name;
    private int age;
    private Long DNI;
    private Long numberOfAppointments =0L;

    //List<String> dates_of_appointments = new ArrayList<>();


    public void numbAppointments(){
        this.numberOfAppointments ++;
    }

    public Patient addSpecialty(MedicalSpecialty medicalSpecialty){
        this.medicalSpecialtyList.add(medicalSpecialty);
        return this;
    }
}
