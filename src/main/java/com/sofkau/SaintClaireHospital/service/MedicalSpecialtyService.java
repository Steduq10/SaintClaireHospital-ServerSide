package com.sofkau.SaintClaireHospital.service;

import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;

import java.util.List;

public interface MedicalSpecialtyService {

    List<MedicalSpecialty> findAllMedicalSpecialty();
    MedicalSpecialty saveMedicalSpecialty(MedicalSpecialty medicalSpecialty);
    MedicalSpecialty findMedicalSpecialty(Long id);
    MedicalSpecialty updateMedicalSpecialty (MedicalSpecialty medicalSpecialty);
    void deleteMedicalSpecialty(Long id);
}
