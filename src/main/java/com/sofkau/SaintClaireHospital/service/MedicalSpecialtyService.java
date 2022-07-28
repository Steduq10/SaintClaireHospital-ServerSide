package com.sofkau.SaintClaireHospital.service;

import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;
import com.sofkau.SaintClaireHospital.entity.Patient;

import java.util.List;

public interface MedicalSpecialtyService {

    List<MedicalSpecialty> findAllMedicalSpecialty();
    Patient saveMedicalSpecialty(MedicalSpecialty medicalSpecialty);
    MedicalSpecialty findMedicalSpecialty(Long id);
    MedicalSpecialty updateMedicalSpecialty (MedicalSpecialty medicalSpecialty);
    void deleteMedicalSpecialty(MedicalSpecialty medicalSpecialty);
}
