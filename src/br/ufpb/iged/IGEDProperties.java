package br.ufpb.iged;

import java.io.*;
import java.util.Calendar;
import java.util.Properties;

public class IGEDProperties {

    private static IGEDProperties instance = null;
    private Properties prop = new Properties();

    private IGEDProperties() {

        try {
            prop.load(new FileInputStream("IGED.properties"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static IGEDProperties getInstance() {

        if (instance == null) {
            instance = new IGEDProperties();
        }

        return instance;

    }

    public String getPropety(String s) {

        return prop.getProperty(s);

    }

    public void setProperty(String key, String value) {
       
        
        prop.setProperty(key, value);
        
        File file = new File("IGED.properties");
        
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream(file);
            //grava os dados  no arquivo  
            prop.store(fos, "alterado indice em "+Calendar.getInstance().getTime());
            
            fos.close();
            
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());            
            
        }

    }
}
