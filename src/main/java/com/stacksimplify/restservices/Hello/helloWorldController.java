package com.stacksimplify.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {
	//simple method
	//uri - /helloworld
	//GET 
	@RequestMapping(method = RequestMethod.GET, path="/helloworld")
	public String helloworld() {
		return "helloworld";
		
	}
	@GetMapping("/helloworld-bean")
	public User helloWorldBean() {
		return new User("malale", "lufungulo", "Arusha");
	}

}
