package com.gl.library.service_interface;

public interface LibraryExistServiceInterface {

	//checkLibraryExistsById(int check_id)
	boolean checkLibraryExistsById(int check_id);

	//checkLibraryExistsByExample Method
	boolean checkLibraryExistsByExample(String bookName);

}