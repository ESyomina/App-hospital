package org.example.apphospital.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.apphospital.model.Doctor;
import org.example.apphospital.model.Patient;
import org.example.apphospital.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PatientService {
    PatientRepository patientRepository;
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    public void del(Integer id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findById(Integer id) {
        return patientRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
