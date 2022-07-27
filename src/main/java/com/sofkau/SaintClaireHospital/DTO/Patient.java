package com.sofkau.SaintClaireHospital.DTO;

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
    private String name;
    private int age;
    private String DNI;
    private Long numberOfAppointments =0L;

    List<String> dates_of_appointments = new ArrayList<>();

    public void numbAppointments(){
        this.numberOfAppointments ++;
    }


}
