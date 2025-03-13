package com.hillel.project_config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static final Properties properties = new Properties();

	static {
		try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
			properties.load(fileInputStream);
		} catch (IOException ioException) {
			throw new RuntimeException("Failed to load configuration file", ioException);
		}
	}

	public static String getProperty(String key) {
		String systemValue = System.getProperty(key);
		System.out.println("=== systemValue" + systemValue);
		return systemValue != null ? systemValue : properties.getProperty(key);
	}
}
