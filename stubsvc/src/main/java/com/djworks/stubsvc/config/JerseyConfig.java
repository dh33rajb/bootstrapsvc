package com.djworks.stubsvc.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.djworks.stubsvc.resource.StubResource;

@Configuration
@ApplicationPath("/stubsvc/v1")
public class JerseyConfig extends ResourceConfig {

	@PostConstruct
	public void init() {
		super.register(StubResource.class);
	}
}
