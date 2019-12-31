package com.hst.reminder.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.hst.reminder.common.exception.ReportableException;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
public class JsonUtils {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static String serialize(Object obj) {
		try {
			return OBJECT_MAPPER.writeValueAsString(obj);
		} catch (Exception e) {
			throw new ReportableException(e);
		}
	}

	public static <T> T deserialize(String json, Class<T> clazz) {
		try {
			return OBJECT_MAPPER.readValue(json, clazz);
		} catch (Exception e) {
			throw new ReportableException(e);
		}
	}

	public static <T> T deserialize(String json, TypeReference<T> typeReference) {
		try {
			return OBJECT_MAPPER.readValue(json, typeReference);
		} catch (Exception e) {
			throw new ReportableException(e);
		}
	}

	public static <T> List<T> deserializeArray(String json, Class<T> clazz) {
		try {
			return OBJECT_MAPPER.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, clazz));
		} catch (Exception e) {
			throw new ReportableException(e);
		}
	}

	public static boolean isValidJson(String json) {
		try {
			OBJECT_MAPPER.readTree(json);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


}