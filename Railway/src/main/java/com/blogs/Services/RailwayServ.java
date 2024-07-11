package com.blogs.Services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.Reposatory.RailwayRepo;
import com.blogs.dto.RailwayDto;
import com.blogs.entities.Category;
import com.blogs.entities.Railway;
import com.blogs.exception.ApiResponse;
import com.blogs.exception.Validations;

@Service
@Transactional
public class RailwayServ implements RailwaySErvInterface{
	@Autowired
        public RailwayRepo railwayrepo;
	 @Autowired
	 private ModelMapper mappe;

	public List<Railway> getAll() {
		
		return railwayrepo.findAll() ;
	}


	public Railway Insert(Railway r) {
		
		 Validations.validateTime(r);
			 return railwayrepo.save(r) ;
		 
		
	}


	
	public void Delete(Long id) {
		railwayrepo.deleteById(id);
		
	}
	
	public List<Railway> getByCategory(String c){
		Category cat=Category.valueOf(c);
		return railwayrepo.getByCateg(cat);
	}
	
	public List<RailwayDto> getallDetails(){
		List<RailwayDto> mydeitail=railwayrepo.findAll()
				.stream()
				.map(Railway->mappe.map(Railway,RailwayDto.class))
				.collect(Collectors.toList());
		return mydeitail;
	}
	
	public Railway Update(Railway r) {
//		Railway rail=(Railway) railwayrepo.findAll().stream().filter(a->(a.Id==r.Id)).;
//		rail.categ=r.categ;
//		rail.code=r.code;
//		rail.destination=r.destination;
//		rail.distance=r.distance;
//		rail.end_time=r.end_time;
		railwayrepo.save(r);
		return r;
		
	}
	
}
