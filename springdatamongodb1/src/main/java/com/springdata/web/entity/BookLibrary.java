package com.springdata.web.entity;

import java.util.Date;


public class BookLibrary {
	
	public BookLibrary(){}

	public BookLibrary(String title, double price,	int volume, Date publishDate, String subtitle, int durationInHours) {
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
	}

	// Book
	String bookId;
	String title;
	double price;
	int volume;
	Date publishDate;
	String stPublishDate;
	
	// Subject
	String subjectId;
	String subtitle;
	int durationInHours;
	String bookIdSubjectId;
	
	//Subject subject;
	/**
	 * @return the id
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param id the id to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}

	/**
	 * @return the publishDate
	 */
	public Date getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * @return the subjectId
	 */
	public String getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * @return the subtitle
	 */
	public String getSubtitle() {
		return subtitle;
	}

	/**
	 * @param subtitle the subtitle to set
	 */
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	/**
	 * @return the durationInHours
	 */
	public int getDurationInHours() {
		return durationInHours;
	}

	/**
	 * @param durationInHours the durationInHours to set
	 */
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	/**
	 * @return the bookIdSubjectId
	 */
	public String getBookIdSubjectId() {
		return bookIdSubjectId;
	}

	/**
	 * @param bookIdSubjectId the bookIdSubjectId to set
	 */
	public void setBookIdSubjectId(String bookIdSubjectId) {
		this.bookIdSubjectId = bookIdSubjectId;
	}
	

	/**
	 * @return the stPublishDate
	 */
	public String getStPublishDate() {
		return stPublishDate;
	}

	/**
	 * @param stPublishDate the stPublishDate to set
	 */
	public void setStPublishDate(String stPublishDate) {
		this.stPublishDate = stPublishDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Library [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + ", subjectId=" + subjectId + ", subtitle=" + subtitle
				+ ", durationInHours=" + durationInHours + "]";
	}

	
	
	
	
}
