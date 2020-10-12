package com.athi.LibraryManagementSystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "LIBRARIANS")
@Table(name = "LIBRARIANS")
public class Librarian implements Serializable {

	private static final long serialVersionUID = 7121465413529096100L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LIBRARIAN_ID", updatable = false, nullable = false)
	private int librarianId;

	@Column(name = "LIBRARIAN_NAME")
	private String librarianName;

	@Column(name = "LICENSE_KEY")
	private String licenseKey;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "PHONE_NUMBER")
	private long phoneNumber;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "LAST_MODIFIED_ON")
	private long lastModifiedOn;

	@Column(name = "LAST_MODIFIED_BY")
	private int lastModifiedBy;

	public int getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(int librarianId) {
		this.librarianId = librarianId;
	}

	public String getLibrarianName() {
		return librarianName;
	}

	public void setLibrarianName(String librarianName) {
		this.librarianName = librarianName;
	}

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(long lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public int getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(int lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Librarian() {
		super();
	}

	public Librarian(int librarianId, String librarianName, String licenseKey, String emailId, long phoneNumber,
			String username, String password, long lastModifiedOn, int lastModifiedBy) {
		super();
		this.librarianId = librarianId;
		this.librarianName = librarianName;
		this.licenseKey = licenseKey;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.lastModifiedOn = lastModifiedOn;
		this.lastModifiedBy = lastModifiedBy;
	}

}
