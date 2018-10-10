package com.springdata.web.springdatamongodb;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdata.web.entity.Book;
import com.springdata.web.entity.BookLibrary;
import com.springdata.web.entity.Subject;

@RestController
@RequestMapping("/libraryapi")
@CrossOrigin("*")
public class BookRestController {
	

	@Autowired
	private BookRepository repositoryBook;
	@Autowired
	private SubjectRepository repositorySubject;
	
	//value=

	@RequestMapping(path="/books", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<BookLibrary>>fetchBooks(){
		//repositoryBook.deleteAll();
		List<BookLibrary> bookLibraries = new ArrayList<BookLibrary>();
		try {
			BookLibrary bookLibrary = null;
			System.out.println("Books found with findAll() -->");
			List<Book> books = repositoryBook.findAll();
			for (Book book : books) {
				//System.out.println(book);
				Subject subject = repositorySubject.findByBookId(book.getBookId());
				
				bookLibrary = new BookLibrary(book.getTitle(), book.getPrice(), book.getVolume(), 
						subject.getSubtitle(), subject.getDurationInHours());
				bookLibrary.setBookId(book.getBookId());
				bookLibrary.setSubjectId(subject.getSubjectId());
				bookLibrary.setBookIdSubjectId(subject.getBookId());
				bookLibrary.setStPublishDate(getStringdateFromUtil(book.getPublishDate()));
				bookLibraries.add(bookLibrary);
				System.out.println("bookLibraries-->" + bookLibraries.toString());
			}
			return new ResponseEntity<List<BookLibrary>>(bookLibraries, HttpStatus.OK);
		} catch(Exception nre){
			return new ResponseEntity<List<BookLibrary>>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public ResponseEntity<Void> createBook(@RequestBody BookLibrary bookLibrary) {
		System.out.println("Creating Book Library-->" + bookLibrary);
		//repositoryBook.deleteAll(); // TODO
		try{
			Book book = new Book(bookLibrary.getTitle(), bookLibrary.getPrice(), bookLibrary.getVolume(), 
					getUtilDate(bookLibrary.getStPublishDate()));
			//book.setBookId(bookLibrary.getBookId());
			Book returnBook = repositoryBook.save(book);
			System.out.println("Created Book-->" + returnBook);
			
			Subject subject = new Subject(returnBook.getBookId(), bookLibrary.getSubtitle(), bookLibrary.getDurationInHours());
			//subject.setSubjectId(bookLibrary.getSubjectId());
			System.out.println("Created Subject-->" + subject);
			Subject returnSubject = repositorySubject.save(subject);
			System.out.println("Created Subject-->" + returnSubject);
			
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception nre){
			return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(path="/book/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<BookLibrary>fetchBook(@PathVariable("id") String id){
		
		BookLibrary bookLibrary = null;
		try {
			Book book = repositoryBook.findByBookId(id);
			
			Subject subject = repositorySubject.findByBookId(book.getBookId());
			
			bookLibrary = new BookLibrary(book.getTitle(), book.getPrice(), book.getVolume(), 
					subject.getSubtitle(), subject.getDurationInHours());
			bookLibrary.setBookId(book.getBookId());
			bookLibrary.setSubjectId(subject.getSubjectId());
			bookLibrary.setBookIdSubjectId(subject.getBookId());
			bookLibrary.setStPublishDate(getStringdateFromUtil(book.getPublishDate()));
			
			return new ResponseEntity<BookLibrary>(bookLibrary, HttpStatus.OK);
		} catch(Exception nre){
			return new ResponseEntity<BookLibrary>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBook(@PathVariable("id") String id){
		System.out.println("Id recieved: " + id);
		repositoryBook.deleteByBookId(id);
		repositorySubject.deleteByBookId(id);
		return new ResponseEntity<Void>(HttpStatus.GONE);
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateBook(@RequestBody BookLibrary newBookLibrary) {
		System.out.println("Update Book " + newBookLibrary);
		
		try{
			Book bookOld = repositoryBook.findByBookId(newBookLibrary.getBookId());
			bookOld.setTitle(newBookLibrary.getTitle());
			bookOld.setPrice(newBookLibrary.getPrice());
			bookOld.setPublishDate(getUtilDate(newBookLibrary.getStPublishDate()));
			bookOld.setVolume(newBookLibrary.getVolume());
			repositoryBook.save(bookOld);
			System.out.println("Book Updated Successfully!!!");
			

			Subject subjectOld = repositorySubject.findByBookId(newBookLibrary.getBookId());
			subjectOld.setDurationInHours(newBookLibrary.getDurationInHours());
			subjectOld.setSubtitle(newBookLibrary.getSubtitle());
			repositorySubject.save(subjectOld);
			System.out.println("Subject Updated Successfully!!!");
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
		catch(Exception nre){
			System.out.println("In Catch-- Update");
			return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
		}	
	}
	

	public Date getUtilDate(String stDate) {
		//String startDate="12-31-2014";
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date = null;
		boolean isNotParse = false;
		try {
			if(null != stDate) {
				date = sdf1.parse(stDate);
			}
		} catch (ParseException e) {
			isNotParse = true;
			System.out.println("Error occured while parsing first time--> " + e.getMessage());
		}

		if(isNotParse){
			try{
				SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date11 = sdf11.parse(stDate);
	
				SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
				String date1 = sdf2.format(date11);
				date = sdf2.parse(date1);
				System.out.println("Parse diff format--> " + date);
				}
			catch(ParseException e) {
				isNotParse = true;
				e.printStackTrace();
			}
		}
		return date;
	}

	/*public Date getSqlDate(String stDate) {
		//String startDate="12-31-2014";
		java.sql.Date sqlStartDate = null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date;
		boolean isNotParse = false;
		try {
			if(null != stDate) {
				date = sdf1.parse(stDate);
				sqlStartDate = new java.sql.Date(date.getTime());
			}
		} catch (ParseException e) {
			isNotParse = true;
			System.out.println("Error occured while parsing first time--> " + e.getMessage());
		}

		if(isNotParse){
			try{
				SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date11 = sdf11.parse(stDate);
	
				SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
				String date1 = sdf2.format(date11);
				
	
				java.util.Date date2 = sdf2.parse(date1);
				
				sqlStartDate = new java.sql.Date(date2.getTime());
				System.out.println("Parse diff format--> " + sqlStartDate);
				}
			catch(ParseException e) {
				isNotParse = true;
				e.printStackTrace();
			}
		}
		return sqlStartDate;
	}*/

	
	/*public String getStringdateFromSql(Date sqlDate) {
		System.out.println("sqlDate-->"+sqlDate);
		String stDate = "";
		if(null != sqlDate) {
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			stDate = df.format(sqlDate); 
		}
		System.out.println("stDate-->"+stDate);
		return stDate;
	}*/
	
	public String getStringdateFromUtil(java.util.Date utilDate) {
		System.out.println("utilDate-->"+utilDate);
		String stDate = "";
		if(null != utilDate) {
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			stDate = df.format(utilDate); 
		}
		System.out.println("stDate-->"+stDate);
		return stDate;
	}
}
