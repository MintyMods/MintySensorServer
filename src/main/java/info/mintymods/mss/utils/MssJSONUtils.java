package info.mintymods.mss.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import info.mintymods.msm.MsmMonitorResponse;

public class MssJSONUtils {

	private static final Logger log = LoggerFactory.getLogger(MssJSONUtils.class);
	final static ObjectMapper mapper = new ObjectMapper();

	public static ObjectMapper getMapper() {
		return mapper;
	}

	public static MsmMonitorResponse getMsmMonitorResponse(String json) {
		try {
			return MssJSONUtils.getMapper().readValue(json, MsmMonitorResponse.class);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static String getJsonString(Object object) {
		try {
			return getMapper().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static boolean isValidJSON(final String json) {
		try {
			getMapper().enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
			getMapper().readTree(json);
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
