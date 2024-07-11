package com.blogs.dto;

import java.time.LocalTime;

import javax.validation.constraints.NotBlank;

import com.blogs.entities.Category;

public class RailwayDto {
	@NotBlank
	public String name;
	@NotBlank
	public Category category;
	@NotBlank
	public LocalTime start_time;
	@NotBlank
	public LocalTime end_time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
	
	
	

}
