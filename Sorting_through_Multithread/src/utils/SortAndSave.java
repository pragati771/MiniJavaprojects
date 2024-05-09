package utils;

import static java.lang.Thread.currentThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;

import com.app.core.Student;

public class SortAndSave implements Runnable {
	String name;
	Map<String, Student> map;
	
	public SortAndSave(String filename,Map<String, Student> map){
		name=filename;
		this.map=map;
	}
	@Override
	public void run() {
		System.out.println(currentThread().getName() + " strted");
		try(PrintWriter pw=new PrintWriter(new FileWriter(name)) ){
			Comparator<Student> comp=(s1,s2)->s1.getDob().compareTo(s2.getDob());
			map.values()
			.stream()
			.sorted(comp)
			.forEach(s->pw.println(s));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(currentThread().getName() + " over");
		
	}

}
