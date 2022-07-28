package com.sofkau.SaintClaireHospital.service;

import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;
import com.sofkau.SaintClaireHospital.entity.Patient;
import com.sofkau.SaintClaireHospital.repository.MedicalSpecialtyRepository;
import com.sofkau.SaintClaireHospital.repository.PatientRepository;

import java.util.List;
import java.util.Objects;

public class MedicalSpecialtyServiceImplementation implements MedicalSpecialtyService{

    private final MedicalSpecialtyRepository medicalSpecialtyRepository;
    private PatientRepository patientRepository;
    public MedicalSpecialtyServiceImplementation(MedicalSpecialtyRepository medicalSpecialtyRepository) {
        this.medicalSpecialtyRepository = medicalSpecialtyRepository;
    }

    @Override
    public List<MedicalSpecialty> findAllMedicalSpecialty() {
        return medicalSpecialtyRepository.findAll();
    }

    @Override
    public Patient saveMedicalSpecialty(MedicalSpecialty medicalSpecialty) {
        Patient patient = patientRepository.findById(medicalSpecialty.getFkDNI()).get();
        Objects.requireNonNull(medicalSpecialty);
        patient.addSpecialty(medicalSpecialty);
        medicalSpecialtyRepository.save(medicalSpecialty);
        return patientRepository.save(patient);
    }

    @Override
    public MedicalSpecialty findMedicalSpecialty(Long id) {
        Objects.requireNonNull(id);
        return medicalSpecialtyRepository.findById(id).get();
    }

    @Override
    public MedicalSpecialty updateMedicalSpecialty(MedicalSpecialty medicalSpecialty) {
        Objects.requireNonNull(medicalSpecialty);
        Objects.requireNonNull(medicalSpecialty.getId());
        medicalSpecialtyRepository.save(medicalSpecialty);
        return medicalSpecialty;
    }

    @Override
    public void deleteMedicalSpecialty(MedicalSpecialty medicalSpecialty) {

        //medicalSpecialtyRepository.deleteById(id);
        medicalSpecialtyRepository.deleteById(medicalSpecialty.getId());
    }
}
