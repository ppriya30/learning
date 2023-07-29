package com.gl.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.library.service.LibraryExistServiceImpl;

@RestController
@RequestMapping("/Exist")
public class LibraryExistController {
	
	@Autowired
	LibraryExistServiceImpl existServiceImpl;
	
	@GetMapping("/checkLibraryExistsById")
	public boolean checkLibraryExistsById(int check_id) {
		return existServiceImpl.checkLibraryExistsById(check_id);
	}
	
	@GetMapping("/checkLibraryExistsByExample")
	public boolean checkLibraryExistsByExample(String bookName) {
		return existServiceImpl.checkLibraryExistsByExample(bookName);
	}
	

}
