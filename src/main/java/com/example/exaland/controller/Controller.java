package com.example.exaland.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.exaland.service.*;

import com.example.exaland.model.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class Controller {
	
	@Autowired Service service1;
	
@PostMapping("/profile")
	
	public  String  seriesAll(@RequestBody Profile data) {
		return service1.profileform(data);
	}

}
