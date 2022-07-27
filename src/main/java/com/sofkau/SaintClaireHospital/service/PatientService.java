package com.sofkau.SaintClaireHospital.service;

import com.sofkau.SaintClaireHospital.dto.PatientMedicalSpecialtyDTO;
import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;
import com.sofkau.SaintClaireHospital.entity.Patient;
import com.sofkau.SaintClaireHospital.repository.MedicalSpecialtyRepository;
import com.sofkau.SaintClaireHospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements MedicalSpecialtyService{

    @Autowired
    //private PatientRepository patientRepository;
    private MedicalSpecialtyRepository medicalSpecialtyRepository;

    @Override
    public List<PatientMedicalSpecialtyDTO> getAllPatientMedicalSpecialty(){
        return medicalSpecialtyRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
    //private
    @Override
    public PatientMedicalSpecialtyDTO convertEntityToDTO(MedicalSpecialty medicalSpecialty){
        PatientMedicalSpecialtyDTO patientMedicalSpecialtyDTO = new PatientMedicalSpecialtyDTO();
        patientMedicalSpecialtyDTO.setPatientID(medicalSpecialty.getId());
        patientMedicalSpecialtyDTO.setName(medicalSpecialty.getName());
        patientMedicalSpecialtyDTO.setPatient(medicalSpecialty.getPatient());

        return patientMedicalSpecialtyDTO;
    }
}
