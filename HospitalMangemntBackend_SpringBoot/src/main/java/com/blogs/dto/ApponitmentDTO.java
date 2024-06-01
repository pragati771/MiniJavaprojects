package com.blogs.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ApponitmentDTO {
	 private String firstName;
	 private String name;
	 private Date appointmentDate;
	    private Time appointmentTime;
}
