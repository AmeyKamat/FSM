package fsm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fsm.exception.FloorSpaceManagementException;

public class JsonFilter {

	public static String filter(Object object, String[] propsToBeIgnored) {
		String filteredObject;
		SimpleBeanPropertyFilter filter;
		filter = SimpleBeanPropertyFilter.serializeAllExcept(propsToBeIgnored);

		FilterProvider filterProvider;
		filterProvider = new SimpleFilterProvider().addFilter("filter", filter);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			filteredObject = objectMapper.writer(filterProvider).writeValueAsString(object);
		}
		catch (JsonProcessingException jpe){
			throw new FloorSpaceManagementException(jpe);
		}
		return filteredObject;
	}
}
