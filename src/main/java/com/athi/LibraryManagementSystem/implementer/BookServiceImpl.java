package com.athi.LibraryManagementSystem.implementer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athi.LibraryManagementSystem.customRepository.LibraryCustomRepositoryImpl;
import com.athi.LibraryManagementSystem.model.Book;
import com.athi.LibraryManagementSystem.repository.BookRepository;
import com.athi.LibraryManagementSystem.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private LibraryCustomRepositoryImpl libraryCustomRepositoryImpl;

	@Override
	public boolean registerBook(Book book, int librarianId) {
		boolean isSaved = false;
		try {
			book.setCreatedBy(librarianId);
			book.setCreatedOn(System.currentTimeMillis());
			book.setLastModifiedBy(librarianId);
			book.setLastModifiedOn(System.currentTimeMillis());
			bookRepository.save(book);
			isSaved = true;
		} catch(Exception exception) {
			isSaved = false;
			exception.printStackTrace();
		}
		return isSaved;
	}

	@Override
	public void deleteBooks(int authorId) {
		libraryCustomRepositoryImpl.deleteBooks(authorId);
	}

	@Override
	public List<Book> fetchAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> fetchBooks(int authorId) {
		return bookRepository.fetchBooks(authorId);
	}

	@Override
	public void deleteBooks(int[] bookIds) {
		for(int id : bookIds) {
			libraryCustomRepositoryImpl.deleteBooksByBookId(id);
		}
	}

	@Override
	public List<Book> searchBooks(String bookName) {
		return bookRepository.fetchBooksByName(bookName);
	}
	
	
}
