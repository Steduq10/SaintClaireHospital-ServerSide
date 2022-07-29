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

    private String name;
    private int age;
    private Long identificationNumber;
    private Long numberOfAppointments =0L;

    private Long fkSpecialtyId;

    private String dateAppointment;

    public void numbAppointments(){
        this.numberOfAppointments ++;
    }



    public Patient addDate(String date) {

        return this;
    }

}
