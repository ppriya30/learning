package com.gl.library.service_interface;

import java.util.List;

import com.gl.library.Entity.Library;

public interface LibraryCreateService_Interface {

	//Creating LibraryCreateServiceImpl Class--addSingleLibrary(Library library)
	String addSingleLibrary(Library library);

	//addAllLibraries Method
	String addAllLibraries(List<Library> add_lib_list);

	//addLibrararywithSaveAndFlush(Library library) Method
	Library addLibrararywithSaveAndFlush(Library library);

}