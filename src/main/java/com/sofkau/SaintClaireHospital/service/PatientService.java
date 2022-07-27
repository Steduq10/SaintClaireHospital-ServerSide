package com.sofkau.SaintClaireHospital.service;

import com.sofkau.SaintClaireHospital.dto.PatientMedicalSpecialtyDTO;
import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;
import com.sofkau.SaintClaireHospital.entity.Patient;

import java.util.List;

public interface PatientService {

    public List<PatientMedicalSpecialtyDTO> getAllPatientMedicalSpecialty();

    public PatientMedicalSpecialtyDTO convertEntityToDTO(Patient patient);

    Patient savePatient (Patient patient);

    Patient findPatientByID(Long id);

    Patient updatePatient(Patient patient);

    void deletePatient(long id);
}
