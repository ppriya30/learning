package com.gl.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import com.gl.library.Entity.Library;
import com.gl.library.repository.LibraryRepo;

@Service
public class LibraryService {
	
	@Autowired 
	LibraryRepo libraryRepo;
	
	
	public List<Library> getAlllibrary() {
		
		return libraryRepo.findAll();
		
	}
	
	public List<Library> getAllLibrarieswithNoBook(){
		Library librarieswithNoBook = new Library();
		librarieswithNoBook.setCommaSeparatedBookname("");
		//important
		ExampleMatcher exMatcher = ExampleMatcher.matching().withMatcher("commaSeparatedBookname",ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
		Example<Library> ex = Example.of(librarieswithNoBook ,exMatcher);
		return libraryRepo.findAll(ex);
	}
	
	//revision
	public List<Library> getAllLibrarieswithNoBooksName(){
		Library librarieswithNoBooksName = new Library();
		librarieswithNoBooksName.setName("");		
		
		ExampleMatcher exampleMatcher= ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","commaSeparatedBookname");
		Example<Library> examp = Example.of(librarieswithNoBooksName, exampleMatcher);
		return libraryRepo.findAll(examp );
	}
	
	
	public Page<Library> getlibrarypaged() {
		Pageable pageable= PageRequest.of(0, 2);
		
		return libraryRepo.findAll(pageable);
		
	}
	
	public Page<Library> getlibraryCustompaged(int pagen,int no_ofrecord){
		
		Pageable pageable = PageRequest.of(pagen, no_ofrecord);
		return libraryRepo.findAll(pageable);
	} 
	
	
//  getLibrariesWithLatestAddedOrder Method---sorting by id
	public List<Library> getLibrariesWithLatestAddedOrder(){
		return libraryRepo.findAll(Sort.by(Direction.DESC, "id"));
	}
	
	
	//getLibrariesCustomSortedById Method
	
	public List<Library> getLibrariesCustomSortedById (Direction direction) {
		
		return libraryRepo.findAll(Sort.by(direction, "id"));
	}
	
	//getLibrariesCustomSortedByName Method
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return libraryRepo.findAll(Sort.by(direction, "name"));
	}
	
	
	//getLibrariesPagedAndSortedByNameAndWithTheseBooks Method
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookname) {
		Library libo = new Library();
		libo.setCommaSeparatedBookname("commaSeparatedBookname");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("commaSeparatedBookname", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
		Example<Library>example=Example.of(libo, exampleMatcher);
		
		Pageable pageable= PageRequest.of(0, 2, Sort.by( "name"));
		return libraryRepo.findAll(example, pageable);
	}
	
	
	
	
	
	//getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks Method(custom pageable+Example)--book needed
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(String commaSeparatedbooksss,int num,int size) {
		Library libarary = new Library();
		libarary.setName("commaSeparatedbooksss");
		ExampleMatcher matcher= ExampleMatcher.matching().withMatcher("commaSeparatedbook", ExampleMatcher.GenericPropertyMatchers.exact())
				 .withIgnorePaths("id","name");
		Example<Library>example=Example.of(libarary, matcher);
		
		Pageable pageable= PageRequest.of(num, size, Sort.by("name"));
		return libraryRepo.findAll(example, pageable);
		
	}
	
	
	
	//getSortedByNameAndWithTheseBooks 
	public List<Library> getSortedByNameAndWithTheseBooks(String Booknames) {
		Library libr = new Library();
		libr.setCommaSeparatedBookname(Booknames);
		ExampleMatcher match = ExampleMatcher.matching().withMatcher("commaSeparatedBookname", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name ");
		Example<Library> example =Example.of(libr, match);
		
		return libraryRepo.findAll(example,Sort.by("name"));
		
		
	}
	
	//getLibrariesByIds Method
	public List<Library> getLibrariesByIds(List<Integer>ids) {
		return libraryRepo.findAllById(ids);
	}
	
	
	//getALibraryById Method
	public Optional<Library> getALibraryById (Integer id_get) {
		return libraryRepo.findById(id_get);
	}
	
	//getALibraryWithTheseBooks Method
	public Optional<Library> getALibraryWithTheseBooks(String commaSepratedBook) {
		Library libr = new Library();
		libr.setCommaSeparatedBookname(commaSepratedBook);
		ExampleMatcher exampleMatcher =ExampleMatcher .matching()
				.withMatcher("commaSeparatedBookname", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library>example=Example.of(libr, exampleMatcher);
		return libraryRepo.findOne(example);
		
	}
	
	//getLibrariesPagedAndSortedByName
		public Page<Library> getLibrariesPagedAndSortedByName() {
			Pageable pagea =PageRequest.of(0, 2, Sort.by("name"));
			return libraryRepo.findAll(pagea);
		}
	
	//Creating LibraryCreateServiceImpl Class--addSingleLibrary(Library library)

	
}
