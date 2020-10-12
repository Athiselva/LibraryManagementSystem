package com.athi.LibraryManagementSystem.service;

import java.util.List;

import com.athi.LibraryManagementSystem.model.Author;

public interface AuthorService {

	public boolean registerAuthor(Author author, int librarianId);
	
	public int getAuthorId(Author author);
	
	public List<Author> fetchAuthors();
	
	public void deleteAuthorById(int authorId);
	
	public int fetchBookCount(int authorId);
}
