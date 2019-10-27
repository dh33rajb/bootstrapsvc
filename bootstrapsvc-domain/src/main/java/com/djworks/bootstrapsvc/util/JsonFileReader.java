package com.djworks.bootstrapsvc.util;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonFileReader {

	private ObjectMapper mapper;

	@PostConstruct
	private void initClient() {
		this.mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public <T extends Object> T readJson(String filePath, Class<T> type) {
		try {
			File file = ResourceUtils.getFile("classpath:" + filePath);
			return this.mapper.readValue(file, type);
		} catch (IOException e) {
			throw new JsonFileReaderException(String.format("Error reading json from file: %s.", filePath), e);
		}
	}
}
