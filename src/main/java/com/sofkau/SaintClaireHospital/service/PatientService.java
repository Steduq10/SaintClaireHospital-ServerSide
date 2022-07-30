package com.sofkau.SaintClaireHospital.service;

import com.sofkau.SaintClaireHospital.dto.PatientMedicalSpecialtyDTO;
import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;
import com.sofkau.SaintClaireHospital.entity.Patient;

import java.util.List;

public interface PatientService {

    public List<PatientMedicalSpecialtyDTO> getAllPatientMedicalSpecialty();

    public PatientMedicalSpecialtyDTO convertEntityToDTO(MedicalSpecialty medicalSpecialty);

    public MedicalSpecialty saveSpecialty (MedicalSpecialty medicalSpecialty);

    MedicalSpecialty findSpecialtyByID(Long id);

    MedicalSpecialty updateSpecialty(MedicalSpecialty medicalSpecialty);

    //void deletePatient(long id);
    void deleteSpecialty (MedicalSpecialty medicalSpecialty);


    List<Patient> findAllPatient();

    MedicalSpecialty savePatient(Patient patient);

    Patient findPatient (Long id);

    Patient updatePatient (Patient patient);

    void deletePatient(Long id);
}
