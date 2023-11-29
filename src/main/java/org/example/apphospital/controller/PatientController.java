package org.example.apphospital.controller;

import lombok.AllArgsConstructor;
import org.example.apphospital.model.Doctor;
import org.example.apphospital.model.Patient;
import org.example.apphospital.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PatientController {
    PatientService patientService;
    @PostMapping("api/patient/v1/patient")
    public ResponseEntity<?> addPatient(@RequestBody Patient patient) {
        patientService.save(patient);
        return ResponseEntity.ok().body("Данные успешно добавлены");
    }

    @GetMapping("api/patient/v1/patient")
    public List<Patient> getListPatient() {
        return patientService.findAll();
    }

    @GetMapping("api/patient/v1/patient/{id}")
    public Patient getInfoDoctor(@PathVariable Integer id) {
        return patientService.findById(id);
    }

    @DeleteMapping("api/patient/v1/patient/{id}")
    public ResponseEntity<?> delPatient(@PathVariable Integer id) {
        patientService.del(id);
        return ResponseEntity.ok().body("Данные успешно удалены");
    }
}
