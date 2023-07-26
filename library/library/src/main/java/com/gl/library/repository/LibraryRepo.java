package com.gl.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.library.Entity.Libarary;

@Repository
public interface LibraryRepo extends JpaRepository<Libarary, Integer> {

}
