package com.athi.LibraryManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.athi.LibraryManagementSystem.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	
	@Query("DELETE FROM BOOKS WHERE AUTHOR_ID = ?1")
	public void deleteBooks(int authorId);
	
	@Query(value = "SELECT * FROM BOOKS WHERE AUTHOR_ID = ?1", nativeQuery = true)
	public List<Book> fetchBooks(int authorId);
	
	@Query(value = "SELECT * FROM BOOKS WHERE BOOK_NAME LIKE LIKE '%?1%'", nativeQuery = true)
	public List<Book> fetchBooksByName(String bookName);
}
