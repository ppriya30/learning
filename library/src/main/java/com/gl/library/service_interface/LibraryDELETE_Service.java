package com.gl.library.service_interface;

import java.util.List;

import com.gl.library.Entity.Library;

public interface LibraryDELETE_Service {

	//DELETE
	//deleteOneLibrary(Library del_lib)
	Object deleteOneLibrary(Library del_lib);

	//pruneTable Method
	String pruneTable();

	//deleteAllThese(List <Library> deleteLibraries) Method
	String deleteAllThese(List<Library> deleteLibraries);

	//deleteAllInBatch Method
	String deleteAllInBatch();

	//deleteLibraryById(int id)
	String deleteLibraryById(int id);

	//deleteAllTheseInBatch Method
	String deleteAllTheseInBatch(List<Library> batchList_Libraries);

}