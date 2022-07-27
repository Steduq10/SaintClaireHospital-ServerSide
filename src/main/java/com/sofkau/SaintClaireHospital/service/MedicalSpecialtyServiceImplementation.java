package com.sofkau.SaintClaireHospital.service;

import com.sofkau.SaintClaireHospital.entity.MedicalSpecialty;
import com.sofkau.SaintClaireHospital.repository.MedicalSpecialtyRepository;

import java.util.List;
import java.util.Objects;

public class MedicalSpecialtyServiceImplementation implements MedicalSpecialtyService{

    private final MedicalSpecialtyRepository medicalSpecialtyRepository;

    public MedicalSpecialtyServiceImplementation(MedicalSpecialtyRepository medicalSpecialtyRepository) {
        this.medicalSpecialtyRepository = medicalSpecialtyRepository;
    }

    @Override
    public List<MedicalSpecialty> findAllMedicalSpecialty() {
        return medicalSpecialtyRepository.findAll();
    }

    @Override
    public MedicalSpecialty saveMedicalSpecialty(MedicalSpecialty medicalSpecialty) {
        Objects.requireNonNull(medicalSpecialty);
        return medicalSpecialtyRepository.save(medicalSpecialty);
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
    public void deleteMedicalSpecialty(Long id) {
        medicalSpecialtyRepository.deleteById(id);
    }
}
