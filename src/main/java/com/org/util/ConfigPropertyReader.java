package com.org.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyReader {
	Properties prop;
	FileInputStream fis;

	/**
	 * 
	 * @return This method is used to load the Property from config properties file depends on Environment
	 */
	
	public Properties getProperty() {

		try {
			fis = new FileInputStream(Constants.config_path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}

}
