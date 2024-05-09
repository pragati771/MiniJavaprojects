package com.app.Util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.CustomerData;
import com.app.core.serviceplan;

public class CustomerCollectionUtils {
		private static int index;

		 public static List<CustomerData> populateList() {
			List<CustomerData> students = new ArrayList<>(
					Arrays.asList(new CustomerData("pragati", "kumrawat","pk90@gmail.com","pkDghy@89",2000,LocalDate.parse("1999-12-13"),serviceplan.valueOf("gold".toUpperCase())),
							new CustomerData("pranoti", "kh","pdfk90@gmail.com","pkDghy@89",2000,LocalDate.parse("1998-12-13"),serviceplan.valueOf("gold".toUpperCase())),
							new CustomerData("anumbhav", "thakur","anu@gmail.com","anuBha@80",5000,LocalDate.parse("2001-12-13"),serviceplan.valueOf("Diamond".toUpperCase())),
							new CustomerData("sakshi", "h","sakshi@gmail.com","Mesakshi@hu&",1000,LocalDate.parse("1999-12-13"),serviceplan.valueOf("Silver".toUpperCase())),
							new CustomerData("shurbi", "rao","sr@gmail.com","srDghy@89",2000,LocalDate.parse("1999-12-13"),serviceplan.valueOf("gold".toUpperCase()))
							));
			
			return students;// rets populated growable list of students with adr
		}

		// add a static method to accept list of student details & rets a map populated with the same
		public static Map<String, CustomerData> populateMap(List<CustomerData> 
		list) {
			HashMap<String, CustomerData> hm = new HashMap<>();
			//declarative (FP) 
			list.forEach(s -> hm.put(s.getEmail(), s));
			return hm;

		}
		
		
		
	}


//pragati kum pk@gmail.com pkDghy@89 2000 2001-09-09 gold
//pragati ku pk90@gmail.com pkDghy@89 2000 2002-09-09 gold
//anu mejta raj@gmail.com kjiHu76@hj 5000 2001-09-09 DIAMOND
//shreya gandhi sr@gmail.com kjiu8#45G 2000 2002-09-09 gold
//anmol gandhi anmol@gmail.net anmol@123$hj 1000 2012-08-08 silver
//khyati gupta khayatime@gmail.com khyatijI&8% 5000 2018-09-08 DIAMOND