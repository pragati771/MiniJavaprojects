package com.blogs.exception;

import com.blogs.entities.Railway;

public class Validations {
	public static boolean validateTime(Railway r) {
		if((r.start_time).isBefore(r.end_time)) {
			return true;
		}
		throw new ApiResponse("invalid time");
		
	}

}
