package org.example.apphospital.controller;

import lombok.AllArgsConstructor;
import org.example.apphospital.dao.VisitAddDao;
import org.example.apphospital.model.Doctor;
import org.example.apphospital.model.Patient;
import org.example.apphospital.model.Visit;
import org.example.apphospital.service.DoctorService;
import org.example.apphospital.service.PatientService;
import org.example.apphospital.service.VisitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class VisitController {
    VisitService visitService;
    DoctorService doctorService;
    PatientService patientService;

    @PostMapping("api/visit/v1/visit")
    public ResponseEntity<?> addDoctor(@RequestBody VisitAddDao visit) {
        Doctor doctor = doctorService.findById(visit.id_doctor);
        Patient patient = patientService.findById(visit.id_patient);
        visitService.save(visit, doctor, patient);
        return ResponseEntity.ok().body("Посещение зарегистрирвоано");
    }

    @GetMapping("api/visit/v1/visit/patient/{id}")
    public List<Visit> getListForPatient(@PathVariable Integer id) {
        return visitService.findAllDyPatientId(id);
    }

    @GetMapping("api/visit/v1/visit/doctor/{id}")
    public List<Visit> getListForDoctor(@PathVariable Integer id) {
        return visitService.findAllDyDoctorId(id);
    }
}
