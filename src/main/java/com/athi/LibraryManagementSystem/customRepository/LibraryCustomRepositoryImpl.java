package com.athi.LibraryManagementSystem.customRepository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class LibraryCustomRepositoryImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean isValidLicense(String licenseKey) {
		boolean isValid = false;
		StringBuilder stringBuilder = null;
		List<Map<String, Object>> outPutList = null;
		try {
			stringBuilder = new StringBuilder();
			stringBuilder.append("SELECT LICENSE_ID FROM LICENSES WHERE LICENSE_KEY = '"+licenseKey+"'");
			outPutList = jdbcTemplate.queryForList(stringBuilder.toString());
			if (!outPutList.isEmpty()) {
				isValid = true;
			} else {
				isValid = false;
			}
		} catch (Exception exception) {
			isValid = false;
			exception.printStackTrace();
		}

		return isValid;
	}
	
	public void deleteBooks(int authorId) {
		StringBuilder stringBuilder = null;
		try {
			stringBuilder = new StringBuilder();
			stringBuilder.append("DELETE FROM BOOKS WHERE AUTHOR_ID = "+authorId);
			jdbcTemplate.execute(stringBuilder.toString());
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void deleteAuthor(int authorId) {
		StringBuilder stringBuilder = null;
		try {
			stringBuilder = new StringBuilder();
			stringBuilder.append("DELETE FROM AUTHORS WHERE AUTHOR_ID = "+authorId);
			jdbcTemplate.execute(stringBuilder.toString());
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void deleteBooksByBookId(int bookId) {
		StringBuilder stringBuilder = null;
		try {
			stringBuilder = new StringBuilder();
			stringBuilder.append("DELETE FROM BOOKS WHERE BOOK_ID = "+bookId);
			jdbcTemplate.execute(stringBuilder.toString());
		} catch(Exception exception) {
			exception.printStackTrace();
		}
	}

}
