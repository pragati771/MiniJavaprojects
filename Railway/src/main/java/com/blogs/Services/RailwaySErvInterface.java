package com.blogs.Services;

import java.util.List;

import com.blogs.dto.RailwayDto;
import com.blogs.entities.Category;
import com.blogs.entities.Railway;

public interface RailwaySErvInterface {
	List<Railway> getAll();
	Railway Insert(Railway r);
	void Delete(Long id);
	List<Railway> getByCategory(String c);
	public List<RailwayDto> getallDetails();
	Railway Update(Railway r);
	

}
