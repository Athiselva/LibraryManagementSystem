package com.athi.LibraryManagementSystem.service;

import java.util.List;

import com.athi.LibraryManagementSystem.model.Book;

public interface BookService {
	
	public boolean registerBook(Book book, int librarianId);
	
	public void deleteBooks(int authorId);
	
	public List<Book> fetchAllBooks();
	
	public List<Book> fetchBooks(int authorId);
	
	public void deleteBooks(int[] bookIds);
	
	public List<Book> searchBooks(String bookName);
}
