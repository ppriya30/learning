package com.gl.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.library.Entity.Library;
import com.gl.library.service.LibraryService;

import lombok.val;

@RestController
@RequestMapping("/Read")
public class LibraryController {
	
	@Autowired
	LibraryService libraryService;
	
	@GetMapping("/getAlllibrary")
	public List<Library> getAlllibrary() {
		return libraryService.getAlllibrary();
	}
	
	@GetMapping("/getAllLibrarieswithNoBook")
	public List<Library> getAllLibrarieswithNoBook() {
		return libraryService.getAllLibrarieswithNoBook();
	}
	
	
	@GetMapping("/getAllLibrarieswithNoBookName")
	public List<Library> getAllLibrarieswithNoBookName() {
		return libraryService.getAllLibrarieswithNoBooksName();
	}
	
	@GetMapping("/getlibrarypaged")
	public Page<Library> getlibrarypaged() {
		return libraryService.getlibrarypaged();
	}
	
	@GetMapping("/getlibraryCustompaged")
	public Page<Library> getlibraryCustompaged(int pagen,int no_ofrecord) {
		return libraryService.getlibraryCustompaged(pagen, no_ofrecord);
		
	}
	
	@GetMapping("/getLibrariesWithLatestAddedOrder")
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return libraryService.getLibrariesWithLatestAddedOrder();
	}

	
	@GetMapping("getLibrariesCustomSortedById")
	public List<Library> getLibrariesCustomSortedById (Direction direction) {
		return libraryService.getLibrariesCustomSortedById(direction);
		}
	
	@GetMapping("/getLibrariesCustomSortedByName")
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return libraryService.getLibrariesCustomSortedByName(direction);
	}
	
	@GetMapping("/getLibrariesPagedAndSortedByNameAndWithTheseBooks")//NOT WORKING PROPERLY
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaBook){
		
		return libraryService.getLibrariesPagedAndSortedByNameAndWithTheseBooks( commaBook);
	}
	
	@GetMapping("/getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks")
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(String commaSeparatedbooksss,int num,int size) {
		return libraryService.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(commaSeparatedbooksss, num, size);
	}
	
	@GetMapping("/getSortedByNameAndWithTheseBooks")
	public List<Library> getSortedByNameAndWithTheseBooks(String bookname) {
		return libraryService.getSortedByNameAndWithTheseBooks(bookname);
	}
	
	@GetMapping("/getALibraryById")
	public Optional<Library> getALibraryById (Integer id_get) {
		return libraryService.getALibraryById(id_get);
	}
	
	@PostMapping("/getLibrariesByIds")
	public List<Library> getLibrariesByIds(@RequestBody List<Integer>ids) {
		return libraryService.getLibrariesByIds(ids);
	}
	
	@GetMapping("/getALibraryWithTheseBooks")
	public Optional<Library> getALibraryWithTheseBooks(String commaSepratedBook) {
		return libraryService.getALibraryWithTheseBooks(commaSepratedBook);
	}
	
	@GetMapping("/getLibrariesPagedAndSortedByName")
	public Page<Library> getLibrariesPagedAndSortedByName() {
		return libraryService.getLibrariesPagedAndSortedByName();
	}
}
