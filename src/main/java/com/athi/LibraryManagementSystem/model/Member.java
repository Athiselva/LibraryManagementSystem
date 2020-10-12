package com.athi.LibraryManagementSystem.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MEMBERS")
@Table(name = "MEMBERS")
public class Member implements Serializable {

	private static final long serialVersionUID = 4804079351239637569L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_ID", updatable = false, nullable = false)
	private int memberId;

	@Column(name = "MEMBER_TYPE")
	private String memberType;

	@Column(name = "MEMBER_NAME")
	private String memberName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PHONE_NUMBER")
	private long phoneNumber;

	@Column(name = "EMAIL")
	private String emailId;

	@Column(name = "DATE_OF_MEMBERSHIP")
	private Date dataOfMembership;

	@Column(name = "NUMBER_OF_BOOKS_ISSUED")
	private int numberOfBooksIssued;

	@Column(name = "NUMBER_OF_BOOKS_RETURNED")
	private int numberOfBooksReturned;

	@Column(name = "NUMBER_OF_BOOKS_INPENDING")
	private int numberOfBooksInpending;

	@Column(name = "MAXIMUM_BOOK_LIMIT")
	private int bookLimit;

	@Column(name = "CREATED_ON")
	private long createdOn;

	@Column(name = "CREATED_BY")
	private int createdBy;

	@Column(name = "LAST_MODIFIED_ON")
	private long lastModifiedOn;

	@Column(name = "LAST_MODIFIED_BY")
	private int lastModifiedBy;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDataOfMembership() {
		return dataOfMembership;
	}

	public void setDataOfMembership(Date dataOfMembership) {
		this.dataOfMembership = dataOfMembership;
	}

	public int getNumberOfBooksIssued() {
		return numberOfBooksIssued;
	}

	public void setNumberOfBooksIssued(int numberOfBooksIssued) {
		this.numberOfBooksIssued = numberOfBooksIssued;
	}

	public int getNumberOfBooksReturned() {
		return numberOfBooksReturned;
	}

	public void setNumberOfBooksReturned(int numberOfBooksReturned) {
		this.numberOfBooksReturned = numberOfBooksReturned;
	}

	public int getNumberOfBooksInpending() {
		return numberOfBooksInpending;
	}

	public void setNumberOfBooksInpending(int numberOfBooksInpending) {
		this.numberOfBooksInpending = numberOfBooksInpending;
	}

	public int getBookLimit() {
		return bookLimit;
	}

	public void setBookLimit(int bookLimit) {
		this.bookLimit = bookLimit;
	}

	public long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
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

	public Member() {
		super();
	}

	public Member(int memberId, String memberType, String memberName, String address, long phoneNumber, String emailId,
			Date dataOfMembership, int numberOfBooksIssued, int numberOfBooksReturned, int numberOfBooksInpending,
			int bookLimit, long createdOn, int createdBy, long lastModifiedOn, int lastModifiedBy) {
		super();
		this.memberId = memberId;
		this.memberType = memberType;
		this.memberName = memberName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.dataOfMembership = dataOfMembership;
		this.numberOfBooksIssued = numberOfBooksIssued;
		this.numberOfBooksReturned = numberOfBooksReturned;
		this.numberOfBooksInpending = numberOfBooksInpending;
		this.bookLimit = bookLimit;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.lastModifiedOn = lastModifiedOn;
		this.lastModifiedBy = lastModifiedBy;
	}

}
