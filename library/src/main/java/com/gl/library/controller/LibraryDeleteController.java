package com.gl.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.library.Entity.Library;
import com.gl.library.service.LibraryDeleteServiceImpl;

@RestController
@RequestMapping("/delete")
public class LibraryDeleteController {
	
	@Autowired
	LibraryDeleteServiceImpl deleteServiceImpl;
	
	@DeleteMapping("/deleteOneLibrary")
	public String deleteOneLibrary(Library del_lib) {
		return deleteServiceImpl.deleteOneLibrary(del_lib);
	}
	
	
	@DeleteMapping("/pruneTable")
	public String pruneTable() {
		return deleteServiceImpl.pruneTable();
	}
	
	@PostMapping("/deleteAllThese")
	public String deleteAllThese(@RequestBody List <Library> deleteLibraries) {
		 return deleteServiceImpl.deleteAllThese(deleteLibraries);
	}
	
	@DeleteMapping("/deleteAllInBatch")
	public String deleteAllInBatch() {
		return deleteServiceImpl.deleteAllInBatch();
	}
	
	@PostMapping("/deleteLibraryById")
	public String deleteLibraryById(int id) {
		return deleteServiceImpl.deleteLibraryById(id);
	}
	
	@DeleteMapping("/deleteAllTheseInBatch")
	public String deleteAllTheseInBatch(@RequestBody List<Library> batchList_Libraries) {
		return deleteServiceImpl.deleteAllTheseInBatch(batchList_Libraries);
	}

}
