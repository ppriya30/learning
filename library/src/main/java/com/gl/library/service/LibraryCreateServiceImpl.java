package com.gl.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.gl.library.Entity.Library;
import com.gl.library.repository.LibraryRepo;
import com.gl.library.service_interface.LibraryCreateService_Interface;

import lombok.val;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService_Interface {

	@Autowired 
	LibraryRepo libraryRepo;
	
	
	//Creating LibraryCreateServiceImpl Class--addSingleLibrary(Library library)
	@Override
	public String addSingleLibrary(Library library) {
		libraryRepo.save(library);
		libraryRepo.flush();
		return "library save";
		
	}
	
	//addAllLibraries Method
	@Override
	public String addAllLibraries(List<Library> add_lib_list) {
		libraryRepo.saveAll(add_lib_list);
		libraryRepo.flush();
		return "library list save";
	}
	
	
	//addLibrararywithSaveAndFlush(Library library) Method
	@Override
	public Library addLibrararywithSaveAndFlush(Library library) {
		return libraryRepo.saveAndFlush(library);
		
	}
	
	
	
	
	
	
	
	
}
