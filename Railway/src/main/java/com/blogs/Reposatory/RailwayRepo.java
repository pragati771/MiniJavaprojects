package com.blogs.Reposatory;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blogs.entities.Category;
import com.blogs.entities.Railway;

public interface RailwayRepo extends JpaRepository<Railway, Long> {
	 @Query("SELECT p FROM Railway p where p.categ=:c")
	    List<Railway> getByCateg(Category c);
	 
//	 @Query("update Railway p set p.category=:r.category , p.code=:r.code ,p.destination=:r.destination,"
//	 		+ "p.distance=:r.distance ,p.end_time=:r.end_time ,p.frequency=:r.frequency,p.name=r.name"
//	 		+ ", p.source=:r.source, p.start_time=:r.start_time where p.id=:r.id")
//	 Railway Update(Railway r);
	 
}
