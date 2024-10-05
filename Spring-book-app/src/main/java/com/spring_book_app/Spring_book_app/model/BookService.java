package com.spring_book_app.Spring_book_app.model;

import com.spring_book_app.Spring_book_app.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public void addBook(Book book)
    {
    bookRepo.save(book);
    }

    public List<Book> getAllBooks()
    {
    return bookRepo.findAll();
    }

    public Book getBook(int bookID) {
        return bookRepo.findById(bookID).orElse(new Book());
    }

    public void updateBook(Book book) {
        bookRepo.save(book);
    }

    public void deleteBook(int bookID)
    {
        bookRepo.deleteById(bookID);
    }

    public void Load()
    {
        List <Book> books = new ArrayList<>(List.of(
        new Book(1,"Harry Potter" , "J.K Rowling",239),
        new Book(2,"Wings of Fire" , "Abdul Kalam",455),
        new Book(3,"Dark" , "Christopher Nolan",78),
        new Book(4,"Abc" , "Emma",210)
    ));
        bookRepo.saveAll(books);
    }

    public List<Book> searchByKey(String author) {
        return bookRepo.findByAuthorContaining(author);
    }
}
