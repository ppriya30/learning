package com.gl.library;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.library.Entity.Libarary;
import com.gl.library.service.LibraryService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LibraryWeek1418Application {
	
	@Autowired
	LibraryService libraryService;

	public static void main(String[] args) {
		SpringApplication.run(LibraryWeek1418Application.class, args);
		System.out.println("hi");
	}
	
	
	public void run(String...args)throws Exception {
		List<Libarary>libararies=libraryService.getAlllibrary();
	    log.info("fetch all library -> {}", libararies);
	    
	    log.info("fetch all libraries with no book -> {}",libraryService.getAllLibrarieswithNoBook());
	}

}
