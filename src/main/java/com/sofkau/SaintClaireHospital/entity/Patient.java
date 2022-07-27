package com.sofkau.SaintClaireHospital.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private MedicalSpecialty medicalSpecialty;

    private String name;
    private int age;
    private Long DNI;
    private Long numberOfAppointments =0L;

    //List<String> dates_of_appointments = new ArrayList<>();

    public void numbAppointments(){
        this.numberOfAppointments ++;
    }


}
