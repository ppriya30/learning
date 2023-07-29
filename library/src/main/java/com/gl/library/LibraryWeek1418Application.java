package com.gl.library;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;


import com.gl.library.Entity.Library;
import com.gl.library.service.LibraryService;
import com.gl.library.service_interface.LibraryCountService_interface;
import com.gl.library.service_interface.LibraryCreateService_Interface;
import com.gl.library.service_interface.LibraryDELETE_Service;
import com.gl.library.service_interface.LibraryExistServiceInterface;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LibraryWeek1418Application {
	
	@Autowired
	LibraryService libraryService;
	@Autowired
	LibraryCreateService_Interface createServiceImpl;
	@Autowired
	LibraryDELETE_Service deleteServiceImpl;
	@Autowired
	LibraryCountService_interface countServiceImpl;
	
	@Autowired
	LibraryExistServiceInterface existServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(LibraryWeek1418Application.class, args);
		System.out.println("hi");
	}
	
	
	public void run(String...args)throws Exception {
		//libraryServicemethodsExecution();
		
		//repo_libraryCreateServiceImpl();
		
		//repo_LibraryCountServiceImpl();
		
		//repo_libraryDeleteServiceImpl();
		
		
		
		//checkLibraryExistsById(int check_id)
		log.info("check library exists by id ->{}", existServiceImpl.checkLibraryExistsById(3));
		//checkLibraryExistsByExample Method
		log.info("check library exists by example ->{}", existServiceImpl.checkLibraryExistsByExample("abc,ghk"));
	
		
		
		
	}


	private void repo_LibraryCountServiceImpl() {
		//count
		log.info(" count the libraries -> {} ",countServiceImpl.countLibraries());
		
		////Adding Method countLibrariesWithZeroBooks Method
		log.info("count libraries with Zero book ->{}", countServiceImpl.countLibrariesWithZeroBooks());
	}


	private void repo_libraryDeleteServiceImpl() {
		//delete
		//deleteOneLibrary(Library del_lib)
 //       log.info("delete library :->{}",deleteServiceImpl.deleteOneLibrary(Library.builder().id(12).name("animals ,bird").commaSeparatedBookname("dszfs").build()));
		//pruneTable Method
//		log.info("delete All libraries :->{}",deleteServiceImpl.pruneTable());
		
		
		//deleteAllThese(List <Library> deleteLibraries)
		List<Library> libraries = new ArrayList<Library>();
		libraries.add(Library.builder().id(3).name("sssahd").commaSeparatedBookname("hjsc").build());
 //       log.info("list of libraries deleted ->{}", deleteServiceImpl.deleteAllThese(libraries));		
	
		
		
		
		////deleteLibraryById(int id)
//		log.info("library deleted by ID ->{}", deleteServiceImpl.deleteLibraryById(7));
	}


	private void repo_libraryCreateServiceImpl() {
		//Creating LibraryCreateServiceImpl Class--addSingleLibrary(Library library)
		log.info("persist a single library",createServiceImpl.addSingleLibrary(Library.builder().id(7).name("motivation library").commaSeparatedBookname("IKKai,Law of attraction").build()));
		
		
		//addAllLibraries Method
		List<Library>lib_list= new ArrayList<Library>();
		lib_list.add(Library.builder().id(12).name("hello world library").commaSeparatedBookname("hello, world").build());
		lib_list.add(Library.builder().id(13).name("hello india").commaSeparatedBookname("Raj, Punjab,Bihar").build());
		log.info("persist all library ->{}",createServiceImpl.addAllLibraries(lib_list));
	
		////addLibrararywithSaveAndFlush(Library library) Method
		log.info("Persist a library ->{}",createServiceImpl.addLibrararywithSaveAndFlush(Library.builder().id(14).name("Animal library").commaSeparatedBookname("robin,moti").build()));
	}


	private void libraryServicemethodsExecution() {
		List<Library>libararies=libraryService.getAlllibrary();
	    log.info("fetch all library -> {}", libararies);
	    
	    log.info("fetch all libraries with no book -> {}",libraryService.getAllLibrarieswithNoBook());
	    
	    
	    Page<Library> page=libraryService.getlibrarypaged();
	    List<Library> lib=page.get().collect(Collectors.toList());
	    log.info("fetch all libraries with page no. -> {}",lib);
	    
	    Page<Library>page1=libraryService.getlibraryCustompaged(0, 3);
	    List<Library>lib1= page1.get().collect(Collectors.toList());
	    log.info("fetch all libraries with custom page no. -> {}",libraryService.getlibraryCustompaged(0, 3));
	    
	    
	    log.info("fetch all libraries with latestes added order(sorting) -> {}",libraryService.getLibrariesWithLatestAddedOrder());
	    
	    
	    log.info("fetch all libraries with custom order(sorting)by ID -> {}",libraryService.getLibrariesCustomSortedById(Direction.DESC));
	    
	    
	    log.info("fetch all libraries with custom order(sorting)by name -> {}",libraryService.getLibrariesCustomSortedByName(Direction.ASC));
	    
	    
	    log.info("fetch libraries default paged and default sorted by name -> {}",libraryService.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));
	    
	    
	    log.info("fetch libraries custom paged and default sorted by name -> {}",libraryService.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks("sudha murthy,surya kant nirala", 1,1).get().collect(Collectors.toList()));
	    
	    
	    log.info("fetch libraries these book and default sorted by name -> {}",libraryService.getSortedByNameAndWithTheseBooks("xyz,abc,efg"));
	    
	    List<Integer>ids= new ArrayList<Integer>();
	    ids.add(2);
	    ids.add(4);
	    log.info("fetch libraries by ids -> {}",libraryService.getLibrariesByIds(ids));
	    
	    
	  //getALibraryById Method
	    int id =3;
	    Optional<Library> optional= libraryService.getALibraryById(id);
	    if(optional.isPresent()) {
	    	log.info("fetch library by id ->{}", optional.get());
	    }
	    else {
			log.info("No matching record found with id "+ id +" in DB");
		}
	    
	    
	    //getALibraryWithTheseBooks
	    Optional<Library>optionalsingle= libraryService.getALibraryWithTheseBooks("xyz,abc,pqr");
	    if (optionalsingle.isPresent()) {
			log.info("fetch library with these books -> {}",optionalsingle.get());
		} else {
			log.info("no matching found with this id "+id);
		}
	}

}
