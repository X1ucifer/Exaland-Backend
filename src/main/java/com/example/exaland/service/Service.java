package com.example.exaland.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.exaland.model.*;

import com.example.exaland.repo.*;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired ProfileRepo repofprofile;
	
	public  String  profileform(Profile data) {
		
		repofprofile.save(data);
		return "Data Saved";
	}

}
