package com.app.dao;

import static com.app.utils.DBUtils.closeConnection;
import static com.app.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.entities.Candidate;
import com.app.entities.User;

public class CandidateDaoImpl implements CandidateDao {
	private Connection cn;
	private PreparedStatement pt1,pt2,pt3,pt4,pt5;
	
	
	//constructor 
	public CandidateDaoImpl() throws SQLException {
		cn = openConnection();
		pt1=cn.prepareStatement("Select * from candidates");
		pt2=cn.prepareStatement("update candidates set votes=(votes+1) where id=?");
		pt3=cn.prepareStatement("update users set status=1 where id=?");
		pt4=cn.prepareStatement("SELECT * FROM candidates ORDER BY votes DESC LIMIT 2");
		pt5=cn.prepareStatement("SELECT party, SUM(votes) AS total_votes FROM candidates GROUP BY party");
	}

	@Override
	public List<Candidate> getAllDetails() throws SQLException {
		List<Candidate> mylist=new ArrayList<>();
		try (ResultSet rst = pt1.executeQuery()) {
			while (rst.next())
				mylist.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
		}
		return mylist;
	}

	@Override
	public List<Candidate> getTopTwo() throws SQLException {
		List<Candidate> mylist2=new ArrayList<>();
		try (ResultSet rst = pt4.executeQuery()) {
			while (rst.next())
				mylist2.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
		}
		
		return mylist2;
	}

	@Override
	public Map<String, Integer> getTotalvotes() throws SQLException {
		Map<String,Integer> mymap=new HashMap<>();
		try(ResultSet rst=pt5.executeQuery()){
			while(rst.next()) {
				mymap.put(rst.getString(1), rst.getInt(2));
			}
		}
		
		return mymap;
	}
	
	@Override
	public String incrementVotes(int id) throws SQLException {
		pt2.setInt(1, id);
		int rows = pt2.executeUpdate();
		if (rows == 1)
			return "Thanks for voting";
		return "Voting failed(invalid!! )!!!!";
	}
	public void changestatus(int id) throws SQLException {
		pt3.setInt(1, id);
		@SuppressWarnings("unused")
		int rows= pt3.executeUpdate();
		
		
	}
	public void cleanUp() throws SQLException {
		System.out.println("user dao cleaned up");
		if (pt1 != null)
			pt1.close();
	if (pt2 != null)
		pt2.close();
		if (pt3 != null)
			pt3.close();
		if (pt4 != null)
			pt4.close();
		closeConnection();
	}

	

}
