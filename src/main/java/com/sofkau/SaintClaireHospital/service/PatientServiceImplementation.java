package com.sofkau.SaintClaireHospital.service;

import com.sofkau.SaintClaireHospital.dto.PatientMedicalSpecialtyDTO;
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
    private final MedicalSpecialtyRepository medicalSpecialtyRepository;

    public PatientServiceImplementation(MedicalSpecialtyRepository medicalSpecialtyRepository) {
        this.medicalSpecialtyRepository = medicalSpecialtyRepository;
    }

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
        //patientMedicalSpecialtyDTO.setMedicalSpecialty(patient.getMedicalSpecialty());

        return patientMedicalSpecialtyDTO;
    }



    @Override
    public Patient savePatient(Patient patient) {
        Objects.requireNonNull(patient);
        return patientRepository.save(patient);
    }

    @Override
    public Patient findPatientByID(Long id) {
        Objects.requireNonNull(id);
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Objects.requireNonNull(patient);
        Objects.requireNonNull(patient.getId());
        patient.numbAppointments(); //Aumenta el número , revisar si funciona
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public void deletePatient(Patient patient) {
        //patientRepository.deleteById(id);
        Patient patientToBeDeleted = patientRepository.findById(patient.getId()).get();
        if (patientToBeDeleted.getMedicalSpecialtyList().size() >= 0) {
            patientToBeDeleted.getMedicalSpecialtyList().forEach(medicalSpecialty -> medicalSpecialtyRepository.deleteById(medicalSpecialty.getId()));
        }
        patientRepository.deleteById(patient.getId());
    }
}
