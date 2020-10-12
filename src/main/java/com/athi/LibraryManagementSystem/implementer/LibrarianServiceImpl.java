package com.athi.LibraryManagementSystem.implementer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athi.LibraryManagementSystem.customRepository.LibraryCustomRepositoryImpl;
import com.athi.LibraryManagementSystem.model.Librarian;
import com.athi.LibraryManagementSystem.repository.LibrarianRepository;
import com.athi.LibraryManagementSystem.service.LibrarianService;

@Service
public class LibrarianServiceImpl implements LibrarianService {

	@Autowired
	private LibrarianRepository librarianRepository;
	
	@Autowired
	private LibraryCustomRepositoryImpl libraryCustomRepositoryImpl;

	@Override
	public boolean register(Librarian librarian) {
		boolean isSaved = false;
		try {
			librarian.setLastModifiedBy(1);
			librarian.setLastModifiedOn(System.currentTimeMillis());
			librarianRepository.save(librarian);
			isSaved = true;
		} catch (Exception exception) {
			isSaved = false;
			exception.printStackTrace();
		}
		return isSaved;
	}

	@Override
	public boolean isValidLicense(String licenseKey) {
		return libraryCustomRepositoryImpl.isValidLicense(licenseKey);
	}

	@Override
	public int getLibrarianId(Librarian librarian) {
		int librarianId = 0;
		try {
			librarianId = librarianRepository.getlibrarianId(librarian.getUsername(), librarian.getPassword());
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return librarianId;
	}
}
