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

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "doctor")
@ToString
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @JsonFormat(pattern="dd.MM.yyyy HH:mm")
    @Column(name = "dtstart")
    private Date dtstart;

    @JsonFormat(pattern="dd.MM.yyyy HH:mm")
    @Column(name = "dtend")
    private Date dtend;

    @OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Visit> visits;

}
