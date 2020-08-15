package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;


public class PropertyUtil {
  private static Properties prop;
  
  public static void intializePropertyFile() throws IOException {
	  File file= new File("E:\\practiceForInterview\\CodeBase\\OrangeHRM_Interview\\OrangeHRM_Interview\\src\\test\\resources\\TestData\\ConfigData.Properties");
	  FileInputStream fis= new FileInputStream(file);
	  prop=new Properties();
	  prop.load(fis);
  }
  
  public static String readProperty(String KeyName) {
	 return prop.getProperty(KeyName);
  }



}
