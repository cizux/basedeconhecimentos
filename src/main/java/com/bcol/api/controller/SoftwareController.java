package com.bcol.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bcol.api.domain.model.Software;
import com.bcol.api.infrastructure.repository.SoftwareRepositoryImpl;

@RestController
@RequestMapping("/softwares")
public class SoftwareController {
	
	@Autowired
	private SoftwareRepositoryImpl softwareRepositoryImpl;
	
	
	public List<Software> listar(){
		return softwareRepositoryImpl.todos();
	}

}
