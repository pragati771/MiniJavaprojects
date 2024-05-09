package utils;

import static java.lang.Thread.currentThread;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;

import com.app.core.Student;
import com.app.core.Subject;

public class Sortedbygpa implements Runnable{
	String name;
	Map<String, Student> map;
	String chossensub;
	public Sortedbygpa(String name, String chossensub, Map<String, Student> map) {
		super();
		this.name = name;
		this.map = map;
		this.chossensub = chossensub;
	}
	

	@Override
	public void run() {
		System.out.println(currentThread().getName() + " strted");
		try(PrintWriter ppw=new PrintWriter(new FileWriter(name)) ){
			Comparator<Student> comp=(s1,s2)->((Double)s1.getGpa()).compareTo((Double)s2.getGpa());
			map.values()
			.stream()
			.filter(s->s.getSubject()==Subject.valueOf(chossensub.toUpperCase()))
			.sorted(comp)
			.forEach(s->ppw.println(s));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(currentThread().getName() + " over");
		
	}
		
	}

	


