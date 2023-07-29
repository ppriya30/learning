package com.gl.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.library.Entity.Library;
import com.gl.library.service.LibraryCreateServiceImpl;
import com.gl.library.service_interface.LibraryCountService_interface;

@RestController
@RequestMapping("/createLibrary")
public class LibraryCreateController {
	
	@Autowired
	LibraryCreateServiceImpl createServiceImpl;
	
	@PostMapping("/addSingleLibrary")
	public String addSingleLibrary(@RequestBody Library library) {
		return createServiceImpl.addSingleLibrary( library);
	}
	
	@PostMapping("/addAllLibraries")
	public String addAllLibraries(@RequestBody List<Library> lib_list) {// for list we haveto use @RequestBody
		return createServiceImpl.addAllLibraries(lib_list);
	}
	
	@PostMapping("/addLibrararywithSaveAndFlush")
	public Library addLibrararywithSaveAndFlush(Library library) {
		return createServiceImpl.addLibrararywithSaveAndFlush(library);
	}

	
	
	
}
