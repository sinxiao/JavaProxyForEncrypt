package com.jxust.svsh.common;

import java.io.IOException;
import java.util.Properties;

public class Configer {
	static{
		new Configer();
	}
	public static String COMMON_KEY = null ;
	public Configer(){
		Properties propterty = new Properties();
		try {
			propterty.load(getClass().getClassLoader().getResourceAsStream("configer.properties"));
			COMMON_KEY = propterty.getProperty("common-key");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
