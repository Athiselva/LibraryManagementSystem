package com.athi.LibraryManagementSystem.implementer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athi.LibraryManagementSystem.customRepository.LibraryCustomRepositoryImpl;
import com.athi.LibraryManagementSystem.model.Author;
import com.athi.LibraryManagementSystem.repository.AuthorRepository;
import com.athi.LibraryManagementSystem.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private LibraryCustomRepositoryImpl libraryCustomRepositoryImpl;

	@Override
	public boolean registerAuthor(Author author, int librarianId) {
		boolean isSaved = false;
		try {
			author.setCreatedBy(librarianId);
			author.setCreatedOn(System.currentTimeMillis());
			author.setLastModifiedBy(librarianId);
			author.setLastModifiedOn(System.currentTimeMillis());
			authorRepository.save(author);
			isSaved = true;
		} catch(Exception exception) {
			isSaved = false;
			exception.printStackTrace();
		}
		return isSaved;
	}

	@Override
	public int getAuthorId(Author author) {
		int authorId = 0;
		List<Author> authors = null;
		try {
			authors = authorRepository.fetchAuthors(author.getAuthorName());
			if(!authors.isEmpty()) {
				author = authors.get(0);
				authorId = author.getAuthorId();
			}
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return authorId;
	}

	@Override
	public List<Author> fetchAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public void deleteAuthorById(int authorId) {
		libraryCustomRepositoryImpl.deleteAuthor(authorId);
	}

	@Override
	public int fetchBookCount(int authorId) {
		return authorRepository.fetchBookCount(authorId);
	}
	
	
}
