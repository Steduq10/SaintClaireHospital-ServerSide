package com.sofkau.SaintClaireHospital.service;

import com.sofkau.SaintClaireHospital.dto.PatientMedicalSpecialtyDTO;
import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;
import com.sofkau.SaintClaireHospital.entity.Patient;
import com.sofkau.SaintClaireHospital.repository.MedicalSpecialtyRepository;
import com.sofkau.SaintClaireHospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PatientServiceImplementation implements PatientService {

    @Autowired
    //private PatientRepository patientRepository;
    private PatientRepository patientRepository;

    @Override
    public List<PatientMedicalSpecialtyDTO> getAllPatientMedicalSpecialty(){
        return patientRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
    //private
    @Override
    public PatientMedicalSpecialtyDTO convertEntityToDTO(Patient patient){
        PatientMedicalSpecialtyDTO patientMedicalSpecialtyDTO = new PatientMedicalSpecialtyDTO();
        patientMedicalSpecialtyDTO.setPatientID(patient.getId());
        patientMedicalSpecialtyDTO.setName(patient.getName());
        patientMedicalSpecialtyDTO.setMedicalSpecialty(patient.getMedicalSpecialty());

        return patientMedicalSpecialtyDTO;
    }

    @Override
    public Patient savePatient(Patient patient) {
        Objects.requireNonNull(patient);
        return patientRepository.save(patient);
    }

    @Override
    public Patient findPatientByID(Long id) {
        return null;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return null;
    }

    @Override
    public void deletePatient(long id) {

    }
}
