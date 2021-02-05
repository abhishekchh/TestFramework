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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {

	public static Logger logger = LogManager.getLogger(Utils.class.getName());

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

	public static String encodeFileToBase64Binary(File file) {
		String encodedfile = null;
		try {
			FileInputStream fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
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

	public static String addDays(String inputDate, int daysToAdd, String dateFormat) throws ParseException {
		String output = addDate(inputDate, daysToAdd, Calendar.DATE, dateFormat);
		logger.info("Old Date {}, days added {}, Updated date {}", inputDate, daysToAdd, output);

		return output;
	}

	public static String addMonths(String inputDate, int monthsToAdd, String dateFormat) throws ParseException {
		String output = addDate(inputDate, monthsToAdd, Calendar.MONTH, dateFormat);
		;
		logger.info("Old Date {}, Months added {}, Updated date {}", inputDate, monthsToAdd, output);
		return output;
	}

	public static String addYears(String inputDate, int yearsToAdd, String dateFormat) throws ParseException {
		String output = addDate(inputDate, yearsToAdd, Calendar.YEAR, dateFormat);
		logger.info("Old Date {}, Years added {}, Updated date {}", inputDate, yearsToAdd, output);
		return output;
	}

	public static String getGreaterDate(String date1, String date2, String dateFormat) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date d1 = sdf.parse(date1);
		Date d2 = sdf.parse(date2);

		if (d1.compareTo(d2) > 0) {
			return date1;
		} else if (d1.compareTo(d2) < 0) {
			return date2;
		} else if (date1.compareTo(date2) == 0) {
			return date1;
		} else {
			return null;
		}

	}

	private static String addDate(String inputDate, int toAdd, int calanderType, String dateFormat) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date oldDate = sdf.parse(inputDate);
		Calendar c = Calendar.getInstance();
		c.setTime(oldDate);
		c.add(calanderType, toAdd);
		return sdf.format(c.getTime());
	}
	
//	public static void main(String[] args) {
//		System.out.println(addDays("01/03/2021", 5, "dd/MM/yyyy"));
//	}

}
