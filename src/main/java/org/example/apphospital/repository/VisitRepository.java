package org.example.apphospital.repository;

import org.example.apphospital.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findAllByPatientId(Integer id);
    List<Visit> findAllByDoctorId(Integer id);
}
