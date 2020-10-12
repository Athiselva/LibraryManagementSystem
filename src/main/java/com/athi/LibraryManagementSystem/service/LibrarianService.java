package com.athi.LibraryManagementSystem.service;

import com.athi.LibraryManagementSystem.model.Librarian;

public interface LibrarianService {
	
	boolean register(Librarian librarian);
	
	boolean isValidLicense(String licenseKey);
	
	int getLibrarianId(Librarian librarian);
}
