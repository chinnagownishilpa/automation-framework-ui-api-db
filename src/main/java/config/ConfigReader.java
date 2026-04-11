package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop=new Properties();
	
	static {
		try {
			String path=System.getProperty("user.dir")+"/src/test/resources/Config.properties";
			FileInputStream fis=new FileInputStream(path);
			prop.load(fis);
		}catch(Exception e) {
			throw new RuntimeException("Failed to load config file");
		}
	}
	
	public static String get(String key) {
		return prop.getProperty(key);
	}
}
