package fsm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public static String readProperty(String key) {
		
		String value = new PropertiesUtilHelper().readProperty(key);
		
		return value;
		
	}
	
}
