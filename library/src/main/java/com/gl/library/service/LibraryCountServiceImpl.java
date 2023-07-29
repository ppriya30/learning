package com.gl.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.gl.library.Entity.Library;
import com.gl.library.repository.LibraryRepo;
import com.gl.library.service_interface.LibraryCountService_interface;

@Service
public class LibraryCountServiceImpl implements LibraryCountService_interface {
	@Autowired
	LibraryRepo libraryRepo;
	//count
	//Creating LibraryCountServiceImpl Class
		@Override
		public long countLibraries() {
			return  libraryRepo.count();
		}
		
		
		//Adding Method countLibrariesWithZeroBooks Method
		@Override
		public long countLibrariesWithZeroBooks() {
			Library lib = new Library();
			lib.setCommaSeparatedBookname("");
			ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("CommaSeparatedBookname", ExampleMatcher.GenericPropertyMatchers.exact())
					.withIgnorePaths("id","name");
			Example<Library>example =Example.of(lib, matcher);
			return libraryRepo.count(example);
		}
		

}
