package org.example.apphospital.controller;

import lombok.AllArgsConstructor;
import org.example.apphospital.model.Doctor;
import org.example.apphospital.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DoctorController {

    DoctorService doctorService;

    @PostMapping("api/doctor/v1/doctor")
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor) {
        doctorService.save(doctor);
        return ResponseEntity.ok().body("Данные успешно добавлены");
    }

    @GetMapping("api/doctor/v1/doctor")
    public List<Doctor> getListDoctor() {
        return doctorService.findAll();
    }

    @GetMapping("api/doctor/v1/doctor/{id}")
    public Doctor getInfoDoctor(@PathVariable Integer id) {
        return doctorService.findById(id);
    }

    @DeleteMapping("api/doctor/v1/doctor/{id}")
    public ResponseEntity<?> delDoctor(@PathVariable Integer id) {
        doctorService.del(id);
        return ResponseEntity.ok().body("Данные успешно удалены");
    }
}
