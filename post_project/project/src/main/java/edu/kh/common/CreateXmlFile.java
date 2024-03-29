package edu.kh.common;

import java.io.FileOutputStream;
import java.util.Properties;

public class CreateXmlFile {
  
	
	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fos = new FileOutputStream("todo.xml");
			Properties prop = new Properties();
			
			prop.storeToXML(fos, "da");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
