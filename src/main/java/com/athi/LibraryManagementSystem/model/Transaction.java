package com.athi.LibraryManagementSystem.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "TRANSACTIONS")
@Table(name = "TRANSACTIONS")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 2264265804001855711L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRANSACTION_ID", updatable = false, nullable = false)
	private long transactionId;

	@Column(name = "MEMBER_ID")
	private int memberId;

	@Column(name = "MEMBER_NAME")
	private String memberName;

	@Column(name = "BOOK_ID")
	private int bookId;

	@Column(name = "AUTHOR_ID")
	private int authorId;

	@Column(name = "BOOK_NAME")
	private String bookName;

	@Column(name = "DATE_OF_ISSUE")
	private Date dateOfIssue;

	@Column(name = "DUE_DATE")
	private Date dueDate;

	@Column(name = "DATE_OF_RETURN")
	private Date dateOfReturn;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "TRANSACTION_ON")
	private long transactionOn;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTransactionOn() {
		return transactionOn;
	}

	public void setTransactionOn(long transactionOn) {
		this.transactionOn = transactionOn;
	}

	public Transaction() {
		super();
	}

	public Transaction(long transactionId, int memberId, String memberName, int bookId, int authorId, String bookName,
			Date dateOfIssue, Date dueDate, Date dateOfReturn, String status, long transactionOn) {
		super();
		this.transactionId = transactionId;
		this.memberId = memberId;
		this.memberName = memberName;
		this.bookId = bookId;
		this.authorId = authorId;
		this.bookName = bookName;
		this.dateOfIssue = dateOfIssue;
		this.dueDate = dueDate;
		this.dateOfReturn = dateOfReturn;
		this.status = status;
		this.transactionOn = transactionOn;
	}

}
