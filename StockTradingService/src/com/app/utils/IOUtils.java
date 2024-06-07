package com.app.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.stock.Stocks;

public class IOUtils {
  public static void writeDetails( Map<Integer,Stocks> mymap,String name) throws FileNotFoundException, IOException {
	  try(ObjectOutputStream os= new ObjectOutputStream(new FileOutputStream(name))){
			os.writeObject(mymap);
		}
  }
  
  public static  Map<Integer,Stocks> getDetails(String name)throws FileNotFoundException, IOException, ClassNotFoundException {
	  try(ObjectInputStream os=new ObjectInputStream(new FileInputStream(name))){
		  return ( Map<Integer,Stocks> )os.readObject();
	  }
	  
  }
}
