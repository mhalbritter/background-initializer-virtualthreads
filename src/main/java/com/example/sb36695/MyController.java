package com.example.sb36695;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Moritz Halbritter
 */
@RestController
class MyController {
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	Dto index() {
		return new Dto(0);
	}
}
