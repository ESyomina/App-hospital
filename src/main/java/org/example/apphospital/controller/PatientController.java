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
@RequestMapping("/patient")
public class PatientController {
    PatientService patientService;
    @PostMapping("/add")
    public ResponseEntity<?> addPatient(@RequestBody Patient patient) {
        patientService.save(patient);
        return ResponseEntity.ok().body("Данные успешно добавлены");
    }

    @GetMapping("/list")
    public List<Patient> getListPatient() {
        return patientService.findAll();
    }

    @GetMapping("/info/{id}")
    public Patient getInfoDoctor(@PathVariable Integer id) {
        return patientService.findById(id);
    }

    @DeleteMapping("/dell/{id}")
    public ResponseEntity<?> delPatient(@PathVariable Integer id) {
        patientService.del(id);
        return ResponseEntity.ok().body("Данные успешно удалены");
    }
}
