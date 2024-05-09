package tester;

import static utils.IOUtils.writeDetails;
import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;

import utils.SortAndSave;
import utils.Sortedbygpa;

public class StoreStudentDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// get the populated map from coll utils
			Map<String, Student> map = populateMap(populateList());
			
			
//			System.out.println("enter your choice");
//			System.out.println("1. sort and save data according to DOb"+"                                       "+
//			"2. sort and save data according to gpa of chossen sub");
//			switch(sc.nextInt()) {
//			case 1:
//				System.out.println("please enter name of file: ");
//				input1=sc.nextLine();
//				break;
//			case 2:
//				System.out.println("please enter the subject(JAVA, PYTHON, DBT, REACT, ANGULAR, SE): ");
//				chossensub=sc.nextLine();
//				System.out.println("please enter the file: ");
//				input1=sc.nextLine();
//				break;
//			}
			System.out.println("please enter name of file: ");
			String input1 =sc.nextLine();
			System.out.println("please enter the subject(JAVA, PYTHON, DBT, REACT, ANGULAR, SE): ");
			String chossensub=sc.nextLine();
			System.out.println("please enter the file: ");
			String input2 =sc.nextLine();
			Thread t1= new Thread(new SortAndSave(input1,map),"one");
			Thread t2= new Thread(new Sortedbygpa(input2,chossensub,map),"two");
			t1.start();
			t2.start();
//			t1.join();
//			t2.join();
			
			
			//writeDetails(map, sc.nextLine());
			//System.out.println("data stored ....");
		} // sc.close()
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over...");

	}

}
