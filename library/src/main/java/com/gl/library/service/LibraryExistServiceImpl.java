package com.gl.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.gl.library.Entity.Library;
import com.gl.library.repository.LibraryRepo;
import com.gl.library.service_interface.LibraryExistServiceInterface;


@Service
public class LibraryExistServiceImpl implements  LibraryExistServiceInterface {
	
	
	@Autowired
	LibraryRepo libraryRepo;
	
	//Creating LibraryExistServiceImpl Class---
	
	
		//checkLibraryExistsById(int check_id)
		@Override
		public boolean checkLibraryExistsById(int check_id) {
			return libraryRepo.existsById(check_id);
		}
		
		
		//checkLibraryExistsByExample Method
		@Override
		public boolean checkLibraryExistsByExample(String bookName) {
			Library library= new Library();
			library.setCommaSeparatedBookname(bookName);
			ExampleMatcher matching =ExampleMatcher.matching().withMatcher("CommaSeparatedBookname", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
			Example<Library>example = Example.of(library, matching);
			return libraryRepo.exists(example);
		}
		
		

}
