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

    private PatientRepository patientRepository;

    @Autowired
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
        patientMedicalSpecialtyDTO.setId(medicalSpecialty.getId());
        patientMedicalSpecialtyDTO.setName(medicalSpecialty.getName());
        patientMedicalSpecialtyDTO.setPhysicianCharge(medicalSpecialty.getPhysicianCharge());
        patientMedicalSpecialtyDTO.setPatientList(medicalSpecialty.getPatientList());
        //patientMedicalSpecialtyDTO.setMedicalSpecialty(patient.getMedicalSpecialty());

        return patientMedicalSpecialtyDTO;
    }

    @Override
    public MedicalSpecialty saveSpecialty(MedicalSpecialty medicalSpecialty) {
        Objects.requireNonNull(medicalSpecialty);
        return medicalSpecialtyRepository.save(medicalSpecialty);
    }

    @Override
    public MedicalSpecialty findSpecialtyByID(Long id) {
        Objects.requireNonNull(id);
        return medicalSpecialtyRepository.findById(id).get();
    }

    @Override
    public MedicalSpecialty updateSpecialty(MedicalSpecialty medicalSpecialty) {
        Objects.requireNonNull(medicalSpecialty);
        Objects.requireNonNull(medicalSpecialty.getId());

        medicalSpecialtyRepository.save(medicalSpecialty);
        return medicalSpecialty;
    }

    @Override
    public void deleteSpecialty(MedicalSpecialty medicalSpecialty) {
        MedicalSpecialty specialtyToBeDeleted = medicalSpecialtyRepository.findById(medicalSpecialty.getId()).get();
        if (specialtyToBeDeleted.getPatientList().size() >= 0) {
            specialtyToBeDeleted.getPatientList().forEach(patient -> patientRepository.deleteById(patient.getId()));
        }
        medicalSpecialtyRepository.deleteById(medicalSpecialty.getId());
    }


    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public MedicalSpecialty savePatient(Patient patient) {
        MedicalSpecialty medicalSpecialty = medicalSpecialtyRepository.findById(patient.getFkSpecialtyId()).get();
        if(medicalSpecialty.getPatientList().contains(patient.getIdentificationNumber())){
            patient.numbAppointments();
            patientRepository.save(patient);
        }else{
            medicalSpecialty.addPatient(patient);
            patient.numbAppointments();
            patientRepository.save(patient);
        }

        return medicalSpecialtyRepository.save(medicalSpecialty);
    }

    @Override
    public Patient findPatient(Long id) {
        Objects.requireNonNull(id);
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Objects.requireNonNull(patient);
        Objects.requireNonNull(patient.getId());
        patient.numbAppointments();
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
