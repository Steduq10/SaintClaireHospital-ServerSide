package com.sofkau.SaintClaireHospital.service;

import com.sofkau.SaintClaireHospital.dto.PatientMedicalSpecialtyDTO;
import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;
import com.sofkau.SaintClaireHospital.dto.PatientMedicalSpecialtyDTO;
import java.util.List;

public interface MedicalSpecialtyService {

    public List<PatientMedicalSpecialtyDTO> getAllPatientMedicalSpecialty();

    public PatientMedicalSpecialtyDTO convertEntityToDTO(MedicalSpecialty medicalSpecialty);
}
