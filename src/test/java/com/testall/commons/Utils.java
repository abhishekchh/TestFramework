package com.testall.commons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;
import java.util.Set;

public class Utils {

	public Utils() {
		loadProperties();
	}

	public static void loadProperties() {
		Properties properties = new Properties();

		try {
			ClassLoader loader = Utils.class.getClassLoader();
			File propertyFile = new File(loader.getResource("test.properties").toURI());
			FileInputStream Locator = new FileInputStream(propertyFile);
			properties = new Properties();
			properties.load(Locator);
			Set<Object> keys = properties.keySet();
			for (Object key : keys) {
				System.out.println(key.toString() + properties.getProperty((String) key));
				System.setProperty(key.toString(), properties.getProperty((String) key));
			}
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String readResourceFile(String fileClassPath) {
		try {
			ClassLoader loader = Utils.class.getClassLoader();

			return new String(Files.readAllBytes(Paths.get(loader.getResource(fileClassPath).toURI())));
		} catch (Exception e) {
		}
		return null;
	}

	public static void writeFile(String fileContent, String filePath) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
		writer.write(fileContent);
		writer.close();
	}
	
	 public static String encodeFileToBase64Binary(File file){
         String encodedfile = null;
         try {
             FileInputStream fileInputStreamReader = new FileInputStream(file);
             byte[] bytes = new byte[(int)file.length()];
             fileInputStreamReader.read(bytes);
             encodedfile = Base64.getEncoder().encodeToString(bytes);
         } catch (FileNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }

         return encodedfile;
     }

}
