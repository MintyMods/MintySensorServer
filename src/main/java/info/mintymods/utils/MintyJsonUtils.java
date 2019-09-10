package info.mintymods.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import info.mintymods.msm.MsmMonitorResponse;
import info.mintymods.msm.MsmSensor;
import info.mintymods.msm.MsmSensorType;
import info.mintymods.msm.exception.MsmException;
import info.mintymods.mss.webapp.exception.MsmServiceProviderProcessingException;
import info.mintymods.mss.webapp.exception.MsmServiceProviderUnavailableException;

public class MintyJsonUtils {

	private static final Logger log = LoggerFactory.getLogger(MintyJsonUtils.class);
	final static ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}

	public static MsmMonitorResponse getMsmMonitorResponse(final String json) throws MsmServiceProviderUnavailableException {
		try {
			final MsmMonitorResponse response = MintyJsonUtils.getMapper().readValue(json, MsmMonitorResponse.class);
			isResponseValid(response);
			return response;
		} catch (final Exception e) {
			throw new MsmServiceProviderUnavailableException(e.getMessage(), e);
		}
	}

	private static void isResponseValid(final MsmMonitorResponse response) throws MsmServiceProviderUnavailableException {
		final MsmException exception = response.getException();
		if (exception != null) {
			throw new MsmServiceProviderUnavailableException(exception.getMessage(), exception.getException());
		}
	}

	public static String getJsonString(final Object object) {
		try {
			return getMapper().writeValueAsString(object);
		} catch (final JsonProcessingException e) {
			throw new MsmServiceProviderProcessingException(e.getMessage(), e);
		}
	}

	public static boolean isValidJSON(final String json) {
		try {
			log.debug("@isValidJSON#" + json);
			getMapper().enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
			getMapper().readTree(json);
		} catch (final IOException e) {
			return false;
		}
		return true;
	}

	public static MsmSensor getMsmSensor(final Object object) {
		final String json = MintyJsonUtils.getJsonString(object);
		return getMsmSensor(json);
	}

	public static MsmSensor getMsmSensor(final String json) {
		try {
			return MintyJsonUtils.getMapper().readValue(json, MsmSensor.class);
		} catch (final Exception e) {
			throw new MsmServiceProviderUnavailableException(e.getMessage(), e);
		}
	}

	public static MsmSensorType getMsmSensorType(final String json) {
		try {
			return MintyJsonUtils.getMapper().readValue(json, MsmSensorType.class);
		} catch (final Exception e) {
			throw new MsmServiceProviderUnavailableException(e.getMessage(), e);
		}
	}

	public static MsmSensorType getMsmSensorType(final Object object) {
		final String json = MintyJsonUtils.getJsonString(object);
		return getMsmSensorType(json);
	}
}
