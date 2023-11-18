package org.example.apphospital.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VisitAddDao {
    public String name;

    @JsonFormat(pattern="dd.MM.yyyy HH:mm")
    public Date date;
    public Integer id_doctor;
    public Integer id_patient;
}
