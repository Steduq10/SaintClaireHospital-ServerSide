package com.sofkau.SaintClaireHospital.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity(name = "Patient")
@Table(name = "patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 10, max = 45, message = "max 45 char")
    private String name;

    @Min(0)
    @Positive
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
