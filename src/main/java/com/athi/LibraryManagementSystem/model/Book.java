package com.athi.LibraryManagementSystem.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "BOOKS")
@Table(name = "BOOKS")
public class Book implements Serializable {

	private static final long serialVersionUID = 8208507296502918903L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID", updatable = false, nullable = false)
	private int bookId;

	@Column(name = "AUTHOR_ID", insertable = false, updatable = false)
	private int authorId;

	@Column(name = "BOOK_NAME")
	private String bookName;

	@Column(name = "PRICE")
	private long price;

	@Column(name = "SECTION_CODE")
	private String sectionCode;

	@Column(name = "RACK_CODE")
	private String rackCode;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "EDITION")
	private String edition;

	@Column(name = "AUTHOR_NAME")
	private String authorName;

	@Column(name = "DATE_OF_PURCHASE")
	private Date dataOfPurchase;

	@Transient
	private String dateOfPurchaseString;

	@Column(name = "CREATED_ON")
	private long createdOn;

	@Column(name = "CREATED_BY")
	private int createdBy;

	@Column(name = "LAST_MODIFIED_ON")
	private long lastModifiedOn;

	@Column(name = "LAST_MODIFIED_BY")
	private int lastModifiedBy;

	@Transient
	private int[] deleteList;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AUTHOR_ID", referencedColumnName = "AUTHOR_ID", unique = true)
	private Author author;

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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getRackCode() {
		return rackCode;
	}

	public void setRackCode(String rackCode) {
		this.rackCode = rackCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getDataOfPurchase() {
		return dataOfPurchase;
	}

	public void setDataOfPurchase(Date dataOfPurchase) {
		this.dataOfPurchase = dataOfPurchase;
	}

	public String getDateOfPurchaseString() {
		return dateOfPurchaseString;
	}

	public void setDateOfPurchaseString(String dateOfPurchaseString) {
		this.dateOfPurchaseString = dateOfPurchaseString;
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

	public int[] getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(int[] deleteList) {
		this.deleteList = deleteList;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book() {
		super();
	}

	public Book(int bookId, int authorId, String bookName, long price, String sectionCode, String rackCode,
			String status, String edition, Date dataOfPurchase, long createdOn, int createdBy, long lastModifiedOn,
			int lastModifiedBy) {
		super();
		this.bookId = bookId;
		this.authorId = authorId;
		this.bookName = bookName;
		this.price = price;
		this.sectionCode = sectionCode;
		this.rackCode = rackCode;
		this.status = status;
		this.edition = edition;
		this.dataOfPurchase = dataOfPurchase;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.lastModifiedOn = lastModifiedOn;
		this.lastModifiedBy = lastModifiedBy;
	}

}
