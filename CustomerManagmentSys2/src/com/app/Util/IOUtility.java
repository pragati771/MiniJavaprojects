package com.app.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.CustomerData;

public class IOUtility {
	// for writing the data from source lets say map
	public static void WriteDetails(Map<String,CustomerData> mymap, String filename) throws FileNotFoundException, IOException {
		try(ObjectOutputStream os= new ObjectOutputStream(new FileOutputStream(filename))){
			os.writeObject(mymap);
		}
	}
 
	@SuppressWarnings("unchecked")
	public static Map<String,CustomerData> ReadDetails(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(ObjectInputStream os= new ObjectInputStream(new FileInputStream(filename))){
			return (Map<String,CustomerData>)os.readObject();
		}
	}

}
