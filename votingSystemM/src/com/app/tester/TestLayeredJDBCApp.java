package com.app.tester;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.dao.CandidateDao;
import com.app.dao.CandidateDaoImpl;
//import com.app.dao.AccountDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.Candidate;
import com.app.entities.User;

public class TestLayeredJDBCApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// 1. init phase --invoked once @ beginning of app
			// created dao instance (i.e Tester :
			// dependent is creating it's own dependency)
			UserDaoImpl userDao = new UserDaoImpl();
			CandidateDaoImpl candidateDao = new CandidateDaoImpl();
			// create acct dao
						boolean exit = false;
						boolean flag=false;
			while (!exit) {
				System.out.println(
						"options: 1. Login \n"+"2 signup\n"+"0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // login
						System.out.println("Enter email n password");
						String mail=sc.next();
						User user = userDao.signIn(mail, sc.next());
						String role=user.getRole();
						System.out.println(role);
						if(user!=null && user.getRole().equals("voter")) {
							System.out.println("Login Successful !!!\n"+""+user.getFirstName());
							while(!flag) {
								System.out.println("Options:\n"+"1.Vote\n"+"2.Update password\n"+"3.delete my account"+"0: Exit");
								switch(sc.nextInt()) {
								case 1:
									if(user.isStatus()==false) {
										System.out.println("Login Successful !!!\n"+"Welcome! "+user.getFirstName());
										System.out.println("Choose option to vote");	
										System.out.println("1 .BJP(Ravi)\n"+"2. NCP(Asha)\n"+"3. Congress(Kiran)\n"+
			                                     "4. SP(Riya)/n"+"5. AAP(Shubhash)");
										String m = candidateDao.incrementVotes(sc.nextInt());
										candidateDao.changestatus(user.getUserId());
										System.out.println(m);
										flag=true;
										
									}
							      else {
										System.out.println("you have alredy voted");
										flag=true;
									}
								
									break;
								case 2:
									System.out.println("Dear Voter , enter email old pwd  n new pwd");
									System.out.println(userDao.changePassword(sc.next(), sc.next(), sc.next()));
									break;
								case 3:
									System.out.println("enter id");
									String v=userDao.deleteuser(sc.nextInt());
									System.out.println(v+" "+user.getFirstName());
									flag=true;
									break;
								case 0:
									flag=true;
									break;
								}
								}
							}
						else if(user!=null){
							System.out.println("welcome back admin!!");
							
							while(!flag) {
								System.out.println("Options: 1.display all candidate\n"+" 2.Get top 2 candidates by votes\n"+
										"3. party total votes\n"+"0: Exit");
								switch(sc.nextInt()) {
								case 1:
									List<Candidate> c= candidateDao.getAllDetails();
									System.out.println("Users -");
								c.forEach(System.out::println);
									break;
								case 2:
									List<Candidate> c2= candidateDao.getTopTwo();
									//System.out.println(c2);
									System.out.println("Users -");
								     c2.forEach(System.out::println);
									break;
								case 3:
									Map<String,Integer> mymap=candidateDao.getTotalvotes();
									System.out.println("Users -");
								     mymap.forEach((k,v)->System.out.println(k+" : "+v));
									break;
								case 0:
									break;
							}
						}}
						else
							System.out.println("Invalid email or password!!!!");
						break;
					
					case 2:
						System.out.println("Enter Voter's details - firstName,  lastName, email,  password,  dob");
						// create transient(not yet persistent in DB) user instance
						user = new User(sc.next(), sc.next(), sc.next(), sc.next(), Date.valueOf(sc.next()));
						System.out.println("Reg status " + userDao.voterRegistration(user));
						break;
					

					case 0:
						exit = true;
						// destroy (shutdown/terminate app)
						userDao.cleanUp();
						candidateDao.cleanUp();						
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
