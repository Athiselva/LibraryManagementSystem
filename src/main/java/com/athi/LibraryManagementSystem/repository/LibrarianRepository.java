package com.athi.LibraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.athi.LibraryManagementSystem.model.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

	@Query(value = "SELECT LIBRARIAN_ID FROM LIBRARIANS WHERE USER_NAME = ?1 AND PASSWORD = ?2", nativeQuery = true)
	int getlibrarianId(String username, String password);
}
