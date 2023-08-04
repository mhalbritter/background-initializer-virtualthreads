package com.example.sb36695;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * @author Moritz Halbritter
 */
@Component
class Requester {
	private final RestClient restClient;

	Requester(RestClient.Builder restClientBuilder) {
		this.restClient = restClientBuilder
				.baseUrl("http://localhost:8080/")
				.build();
	}

	@EventListener(ApplicationReadyEvent.class)
	void onReady() {
		Dto dto = restClient.get().uri("/").accept(MediaType.APPLICATION_JSON).retrieve().body(Dto.class);
		System.out.printf("Got response %s, duration since started: %s%n", dto, Timing.INSTANCE.elapsedSinceStart());
	}
}
