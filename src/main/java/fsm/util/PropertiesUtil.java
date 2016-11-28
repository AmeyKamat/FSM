package fsm.util;

import fsm.util.PropertiesUtilHelper;

public class PropertiesUtil {
	
	public static String readProperty(String key) {
		
		String value = new PropertiesUtilHelper().readProperty(key);
		
		return value;
		
	}
	
}
