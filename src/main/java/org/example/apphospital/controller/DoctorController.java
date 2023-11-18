package org.example.apphospital.controller;

import lombok.AllArgsConstructor;
import org.example.apphospital.model.Doctor;
import org.example.apphospital.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {

    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor) {
        doctorService.save(doctor);
        return ResponseEntity.ok().body("Данные успешно добавлены");
    }

    @GetMapping("/info/{id}")
    public Doctor getInfoDoctor(@PathVariable Integer id) {
        return doctorService.findById(id);
    }

    @GetMapping("/list")
    public List<Doctor> getListDoctor() {
        return doctorService.findAll();
    }

    @DeleteMapping("/dell/{id}")
    public ResponseEntity<?> delDoctor(@PathVariable Integer id) {
        doctorService.del(id);
        return ResponseEntity.ok().body("Данные успешно удалены");
    }
}
