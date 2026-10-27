package com.tka.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Book;
import com.tka.service.BookService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/book")

public class BookController {
	
	private BookService bs;
	
	public BookController(BookService bs) {
		this.bs=bs;
	}

	@GetMapping("/getAll")
	public List<Book> getAllBook() {
		return bs.getAllBook();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBookById(@PathVariable int id) {
		return bs.deleteBookById(id);
	}
	
	@PostMapping("/add/")
	public String addBook(@RequestBody Book book) {
		return bs.addBook(book);
	}
	
	@PutMapping("/update/{id}/")
	public String updateBook(@RequestBody Book book , @PathVariable int id) {
		return bs.updateBook(book , id);
	}
	
	@GetMapping("/gettitle/{searchTitle}")
	public List<Book> getBookByTitle(@PathVariable String searchTitle){
		return bs.getBookByTitle(searchTitle);
	}

	@GetMapping("/getAuthor/{author}")
	public List<Book> getBookByAuthor(@PathVariable String author){
		return bs.getBookByAuthor(author);
	}
	
	@GetMapping("/getCat/{cate}")
	public List<Book> getBookByCategory(@PathVariable String cate){
		return bs.getBookByCategory(cate);
	}
	
	
	
}
