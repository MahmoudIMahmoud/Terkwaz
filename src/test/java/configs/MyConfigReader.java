package configs;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class MyConfigReader {

	private Properties properties = null;
	private static MyConfigReader cfgs= new MyConfigReader();
	
	private MyConfigReader() {
		properties = new Properties();
		InputStream propertiesFile;
		try {
			propertiesFile = new FileInputStream("./configs/configs.properties");
			properties.load(propertiesFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getCfgValue(String key) {
		if(cfgs.properties.containsKey(key))
			return cfgs.properties.getProperty(key);
//		else throw new Exception("key "+key + " is not found");
		return null;
	}
	
	
}
