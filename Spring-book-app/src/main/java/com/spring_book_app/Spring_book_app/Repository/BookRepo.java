package com.spring_book_app.Spring_book_app.Repository;

import com.spring_book_app.Spring_book_app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository <Book,Integer> {

     List<Book> findByAuthorContaining(String author);
}



