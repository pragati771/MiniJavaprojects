package com.blogs.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="railway")
public class Railway {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long Id;
	@Column(name="name",length=30)
	public String name;
	@Enumerated(EnumType.STRING)
	@Column(name="category",length=30)
	public Category categ;
	public LocalTime start_time;
	public LocalTime end_time;
	public String source;
	public String destination;
	public int code;
	public double distance;
	public String frequency;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCateg() {
		return categ;
	}
	public void setCateg(Category categ) {
		this.categ = categ;
	}
	public LocalTime getStart_time() {
		return start_time;
	}
	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}
	public LocalTime getEnd_time() {
		return end_time;
	}
	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	@Override
	public String toString() {
		return "Railway [Id=" + Id + ", name=" + name + ", categ=" + categ + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", source=" + source + ", destination=" + destination + ", code=" + code
				+ ", distance=" + distance + ", frequency=" + frequency + "]";
	}
	
	
	

	
	
	

}
