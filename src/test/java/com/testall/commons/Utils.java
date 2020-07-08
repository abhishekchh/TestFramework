package com.testall.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.Set;

public class Utils {
	
	public Utils(){
		loadProperties();
	}
	
	public static void loadProperties(){
		Properties properties = new Properties();
		
		try {
			ClassLoader loader = Utils.class.getClassLoader();
			File propertyFile = new File(loader.getResource("test.properties").toURI());
			FileInputStream Locator = new FileInputStream(propertyFile);
			properties = new Properties();
			properties.load(Locator);
			Set<Object> keys = properties.keySet();
			for (Object key : keys) {
				System.out.println(key.toString()+ properties.getProperty((String) key));
				System.setProperty(key.toString(), properties.getProperty((String) key));
			}
		}catch (URISyntaxException|IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
