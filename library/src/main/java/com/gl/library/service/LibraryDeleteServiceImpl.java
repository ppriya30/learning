package com.gl.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.library.Entity.Library;
import com.gl.library.repository.LibraryRepo;
import com.gl.library.service_interface.LibraryDELETE_Service;

@Service
public class LibraryDeleteServiceImpl implements LibraryDELETE_Service {
	
	@Autowired
	LibraryRepo libraryRepo;
	
	
	//DELETE
		//deleteOneLibrary(Library del_lib)
		@Override
		public String deleteOneLibrary(Library del_lib) {
			libraryRepo.delete(del_lib);
			return "library deleted"+ del_lib;
		}
		
		//pruneTable Method
		@Override
		public String pruneTable() {
			libraryRepo.deleteAll();
			return "All recordes deleted";
		}
		
		//deleteAllThese(List <Library> deleteLibraries) Method
		@Override
		public String deleteAllThese(List <Library> deleteLibraries) {
			libraryRepo.deleteAll(deleteLibraries);
			return "list of libraries deleted";
		}
		
		//deleteAllInBatch Method
		@Override
		public String deleteAllInBatch() {
			libraryRepo.deleteAllInBatch();
			return "deleteAllInBatch Method";
		}
		
		//deleteLibraryById(int id)
		@Override
		public String deleteLibraryById(int id) {
			libraryRepo.deleteById(id);
			return "deleted by ID";
		}
		
		//deleteAllTheseInBatch Method
		@Override
		public String deleteAllTheseInBatch(List<Library> batchList_Libraries) {
			libraryRepo.deleteInBatch(batchList_Libraries);
			return "batch of libraries in list is delete "; 
		}

}
