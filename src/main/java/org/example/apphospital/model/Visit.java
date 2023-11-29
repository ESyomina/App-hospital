package org.example.apphospital.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.ToString;

import javax.print.Doc;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonFormat(pattern="dd.MM.yyyy HH:mm")
    private Date date;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_patient", nullable = false)
    @JsonIgnore
    private Patient patient;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_doctor", nullable = false)
    @JsonIgnore
    private Doctor doctor;

    public Visit(Date date, String name, Patient patient, Doctor doctor) {
        this.date = date;
        this.name = name;
        this.patient = patient;
        this.doctor = doctor;
    }
}
