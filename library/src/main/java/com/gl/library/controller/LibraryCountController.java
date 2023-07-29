package com.gl.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.library.service.LibraryCountServiceImpl;
import com.gl.library.service_interface.LibraryCountService_interface;

@RestController
@RequestMapping("/countService")
public class LibraryCountController {
	
	@Autowired
	LibraryCountService_interface countService_interface;
	
	@GetMapping("/countLibraries")
	public long countLibraries() {
		
		return countService_interface.countLibraries();
		
	}
	
	@GetMapping("/countLibrariesWithZeroBooks")
	public long countLibrariesWithZeroBooks() {
		return countService_interface.countLibrariesWithZeroBooks();
	}

}
