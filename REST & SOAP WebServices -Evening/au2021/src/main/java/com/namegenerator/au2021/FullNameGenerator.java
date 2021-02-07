package com.namegenerator.au2021;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/stringoperations")
public class FullNameGenerator {

	@GetMapping("/generate/{firstName}/{lastName}")
	public String generate(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName)
	{
		return firstName+lastName;
	
	}
	
	@GetMapping("/split/{string1}/{string2}")
	public String split(@PathVariable("string1") String firstName, @PathVariable ("string2") String lastName) {
		return firstName.split(lastName)[0];
	}
}
