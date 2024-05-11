package com.app.dao;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.app.entities.*;
import com.app.entities.User;

public interface CandidateDao {
//	1. Get all candidates
//	2. Increment candidate's votes(by candidate id)
//	3. Get to 2 candidates by votes
//	4. Get party name n total votes(group by)
	List<Candidate> getAllDetails() throws SQLException;
	String incrementVotes(int id) throws SQLException;
	List<Candidate> getTopTwo() throws SQLException;
	Map<String,Integer> getTotalvotes() throws SQLException;
	

}
