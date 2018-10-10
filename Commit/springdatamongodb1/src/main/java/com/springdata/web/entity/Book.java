package com.springdata.web.entity;

import java.util.Date;
import org.springframework.data.annotation.Id;


public class Book {
	
	public Book(){}

	public Book(String title, double price,	int volume, Date publishDate) {
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
	}

	@Id
	String bookId;
	
	String title;
	double price;
	int volume;
	Date publishDate;
	
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

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume + ", publishDate="
				+ publishDate + "]";
	}

	/**
	 * @return the subject
	 */
	/*public Subject getSubject() {
		return subject;
	}*/

	/**
	 * @param subject the subject to set
	 */
	/*public void setSubject(Subject subject) {
		this.subject = subject;
	}*/
	
	
	
	
	
}
