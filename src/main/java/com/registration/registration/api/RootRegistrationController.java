package com.registration.registration.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RootRegistrationController {

	@GetMapping("/")
	ResponseEntity<String> index() {
	    return new ResponseEntity<>("Welcome to index", HttpStatus.OK);
	}

	@GetMapping("/failure")
	ResponseEntity<String> fail() {
	    return new ResponseEntity<>("Some failure happened", HttpStatus.OK);
	}
	 
	
}
