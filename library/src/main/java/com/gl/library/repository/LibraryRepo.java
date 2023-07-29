package com.gl.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.library.Entity.Library;
import com.gl.library.Entity.Library;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Integer> {

}
