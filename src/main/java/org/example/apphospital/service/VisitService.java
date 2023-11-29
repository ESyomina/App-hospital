package org.example.apphospital.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.apphospital.dao.VisitAddDao;
import org.example.apphospital.model.Doctor;
import org.example.apphospital.model.Patient;
import org.example.apphospital.model.Visit;
import org.example.apphospital.repository.VisitRepository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class VisitService {
    VisitRepository visitRepository;
    public void save(VisitAddDao visitData, Doctor doctor, Patient patient) {
        visitRepository.save(new Visit(visitData.date, visitData.name, patient, doctor));
    }

    public List<Visit> findAllDyPatientId(Integer id) {
        return visitRepository.findAllByPatientId(id);
    }

    public List<Visit> findAllDyDoctorId(Integer id) {
        return visitRepository.findAllByDoctorId(id);
    }
}
