package com.registration.registration.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/authnz")
public class RegistrationController {
	
	 
	@GetMapping("/user") //any authorized user
	ResponseEntity<String> user() {
	    return new ResponseEntity<>("GET Hello user!", HttpStatus.OK);
	}
	@GetMapping("/super/payments") //for super role
	ResponseEntity<String> payments() {
	    return new ResponseEntity<>("GET all super payments!", HttpStatus.OK);
	}
	
}
