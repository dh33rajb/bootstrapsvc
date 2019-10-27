package com.djworks.bootstrapsvc.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.djworks.bootstrapsvc.resource.BootstrapResource;

@Configuration
@ApplicationPath("/bootstrapsvc/v1")
public class JerseyConfig extends ResourceConfig {

	@PostConstruct
	public void init() {
		super.register(BootstrapResource.class);
	}
}
