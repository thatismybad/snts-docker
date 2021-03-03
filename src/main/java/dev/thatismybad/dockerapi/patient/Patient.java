package dev.thatismybad.dockerapi.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "personal_id", unique = true, nullable = false)
    private String personalId;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    @Column(name = "patient_status", nullable = false)
    private PatientStatus status = PatientStatus.NA;
}
