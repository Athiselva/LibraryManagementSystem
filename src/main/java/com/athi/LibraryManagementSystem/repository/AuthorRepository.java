package com.athi.LibraryManagementSystem.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.athi.LibraryManagementSystem.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

	@Query(value = "SELECT * FROM AUTHORS WHERE AUTHOR_NAME = ?1", nativeQuery = true)
	public List<Author> fetchAuthors(String authorName);
	
	@Query(value = "SELECT COUNT(BOOK_ID) FROM BOOKS WHERE AUTHOR_ID = ?1", nativeQuery = true)
	public int fetchBookCount(int authorId);
	
	@Query(value = "DELETE FROM AUTHORS WHERE AUTHOR_ID = ?1", nativeQuery = true)
	public void deleteByAuthorId(int authorId);
	
}
