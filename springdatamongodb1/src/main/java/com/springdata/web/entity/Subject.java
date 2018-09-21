package com.springdata.web.entity;

import org.springframework.data.annotation.Id;


public class Subject {
	
	public Subject(){}

	public Subject(String bookId, String subtitle, int durationInHours) {
		this.bookId = bookId;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
	}

	@Id
	String subjectId;
	String bookId;
	
	String subtitle; // subjectId
	int durationInHours;
	

	
	
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
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours + ", bookId=" + bookId;
	}

	
	
	
	
	
	
	
}
