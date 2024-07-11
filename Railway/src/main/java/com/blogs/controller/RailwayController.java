package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.Services.RailwaySErvInterface;
import com.blogs.dto.RailwayDto;
import com.blogs.entities.Category;
import com.blogs.entities.Railway;

@RestController
@RequestMapping("/railway")
public class RailwayController {
	@Autowired
	public RailwaySErvInterface railwayservinterface;
	
	@GetMapping
	public List<Railway> getall(){
		return railwayservinterface.getAll();
	}
	
	@PostMapping("/insert")

	public Railway Insert(@RequestBody Railway r) {
		return railwayservinterface.Insert(r);
	}
	
	@GetMapping("/delete/{id}")
	public void Delete(@PathVariable Long id) {
		railwayservinterface.Delete(id);
	}
	@GetMapping("/category/{c}")
	public List<Railway> getByCategory(String c){
		return railwayservinterface.getByCategory(c);
	}
	
	@GetMapping("/mydetails")
	public List<RailwayDto> getallDetails(){
		return railwayservinterface.getallDetails();
	}
	
	@PostMapping("/update")

	public Railway Update(@RequestBody Railway r) {
		return railwayservinterface.Update(r);
	}
	
	
}
