package com.gl.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.library.Entity.Libarary;
import com.gl.library.repository.LibraryRepo;

@Service
public class LibraryService {
	
	@Autowired 
	LibraryRepo libraryRepo;
	
	
	public List<Libarary> getAlllibrary() {
		
		return libraryRepo.findAll();
		
	}

}
