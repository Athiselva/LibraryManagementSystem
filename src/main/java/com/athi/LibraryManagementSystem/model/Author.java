package com.athi.LibraryManagementSystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "AUTHORS")
@Table(name = "AUTHORS")
public class Author implements Serializable {

	private static final long serialVersionUID = -7533549217320526801L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AUTHOR_ID", updatable = false, nullable = false)
	private int authorId;

	@Column(name = "AUTHOR_NAME", unique = true)
	private String authorName;

	@Column(name = "SECTION_CODE")
	private String sectionCode;

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
	
	@Transient
	private int[] viewList;
	
	@Transient
	private String actionType;
	
	@Transient
	private int bookCount;
	
	@OneToOne(mappedBy = "author")
	private Book book;
	
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
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
	
	public int[] getViewList() {
		return viewList;
	}

	public void setViewList(int[] viewList) {
		this.viewList = viewList;
	}
	
	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Author() {
		super();
	}

	public Author(int authorId, String authorName, String sectionCode, long createdOn, int createdBy,
			long lastModifiedOn, int lastModifiedBy, int[] deleteList, int[] viewList, String actionType,
			int bookCount, Book book) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.sectionCode = sectionCode;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.lastModifiedOn = lastModifiedOn;
		this.lastModifiedBy = lastModifiedBy;
		this.deleteList = deleteList;
		this.viewList = viewList;
		this.actionType = actionType;
		this.bookCount = bookCount;
		this.book = book;
	}

	

}
