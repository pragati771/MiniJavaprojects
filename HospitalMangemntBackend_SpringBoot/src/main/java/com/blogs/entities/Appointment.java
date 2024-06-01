package com.blogs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentID;

    @ManyToOne
    @JoinColumn(name = "did",referencedColumnName = "did")
    private Doctors doctor;

    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Patients patient;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
	

    // Constructors, getters, and setters
    
}

    


