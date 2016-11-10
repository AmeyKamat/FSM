package fsm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtilHelper {
	
	public String readProperty(String key) {
		
		String value = "Error Reading from property file";
		
		try {
			
			Properties props = new Properties();
			
			InputStream fin = this.getClass().getClassLoader().getResourceAsStream("app.properties");
			props.load(fin);
			
			value = props.getProperty(key);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return value;
		
	}
	
}
