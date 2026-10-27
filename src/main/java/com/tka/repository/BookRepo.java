package com.tka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book , Integer>{

	List<Book> findByTitle(String searchTitle);

	List<Book> findByAuthor(String author);

	List<Book> findByCategory(String cate);

}
