package fsm.util;

public class PropertiesUtil {
	
	public static String readProperty(String key) {
		
		String value = new PropertiesUtilHelper().readProperty(key);
		
		return value;
		
	}
	
}
