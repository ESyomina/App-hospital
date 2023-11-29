package org.example.apphospital.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.apphospital.model.Doctor;
import org.example.apphospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DoctorService {

    DoctorRepository doctorRepository;

    public void del(int id) {
        doctorRepository.deleteById(id);
    }
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Doctor findById(Integer id) {
        return doctorRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
