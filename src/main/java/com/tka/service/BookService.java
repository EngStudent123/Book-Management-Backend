package com.tka.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tka.entity.Book;
import com.tka.repository.BookRepo;

@Service
public class BookService {

	private BookRepo br;
	
	public BookService( BookRepo br) {
		this.br=br;
	}

	public List<Book> getAllBook() {
		return br.findAll();
	}

	public String deleteBookById(int id) {
		br.deleteById(id);
		return "deleted successfully!";
	}

	public String addBook(Book book) {
		br.save(book);
		return "Added Successfully";
	}

	public String updateBook(Book book, int id) {
		
		Book b = br.findById(id).orElse(null);
		
		book.setId(b.getId());
		
		br.save(book);
		return "Updated Successfully!";
	}

	public List<Book> getBookByTitle(String searchTitle) {
		return br.findByTitle(searchTitle);
	}

	public List<Book> getBookByAuthor(String author) {
		
		return br.findByAuthor(author);
	}

	public List<Book> getBookByCategory(String cate) {
		
		return br.findByCategory(cate);
	}
	
	
	
	
}
