package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	/*private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(12,"python","abc"));
		list.add(new Book(13,"c++","def"));
		list.add(new Book(14,"c","wxy"));
	}*/
	
	public  List<Book> getAllBooks(){
		 List<Book> list = (List<Book>)this.bookRepository.findAll();
		 return list;
	}
	
	
	
	
	public Book addBook(Book b ) {
		Book result =this. bookRepository.save(b);
	
		return result;
	}
	
	public void deleteBook(int id) {
		//list = list.stream().filter(book->{
		//	if(book.getId()!=id) {
			//	return true;
		//	}else {
			//	return false;
			//}
		//}).collect(Collectors.toList());
		//list.remove(id);
		
		bookRepository.deleteById(id);
	}
	
	public void updateBook(Book book, int bookId) {
		book.setId(bookId);
		bookRepository.save(book);
		
	}
}
