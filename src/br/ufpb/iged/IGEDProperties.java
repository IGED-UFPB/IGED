package br.ufpb.iged;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class IGEDProperties {
	
	private static IGEDProperties instance = null;
	private Properties prop = new Properties();
	
	private IGEDProperties() {
		
		try {
			prop.load(new FileInputStream("IGED.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static IGEDProperties getInstance(){
		
		if(instance == null){
			instance = new IGEDProperties();
		}
		
		return instance;
		
	}
	
	public String getPropety(String s){
		
		return prop.getProperty(s);	
		
	}
	
	

}
