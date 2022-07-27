package com.sofkau.SaintClaireHospital.DTO;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
@Data
public class Patient {



    private Long id;
    private String name;
    private int age;

    List<String> dates_of_appointments = new ArrayList<>();
}
