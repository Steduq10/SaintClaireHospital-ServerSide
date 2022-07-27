package com.sofkau.SaintClaireHospital.repository;

import com.sofkau.SaintClaireHospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
