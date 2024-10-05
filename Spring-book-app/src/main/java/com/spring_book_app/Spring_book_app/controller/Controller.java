package com.spring_book_app.Spring_book_app.controller;


import com.spring_book_app.Spring_book_app.Repository.BookRepo;
import com.spring_book_app.Spring_book_app.model.Book;
import com.spring_book_app.Spring_book_app.model.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
    private final BookRepo bookRepo;

    @Autowired
    BookService bookService;

    public Controller(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/")
    public String home()
    {
    return "Home page";
    }


    @PostMapping ("Book")
    public Book addBook(@RequestBody Book book)
    {
        bookService.addBook(book);
        return bookService.getBook(book.getId());
    }

    @GetMapping("Books")
    public List<Book> viewAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("Book/{bookID}")
    public Book getBook(@PathVariable ("bookID") int bookID)
    {
        return bookService.getBook(bookID);
    }

    @PutMapping("Book")
    public Book updateBook(Book book)
    {
        bookService.updateBook(book);
        return bookService.getBook(book.getId());
    }

    @DeleteMapping("Book/{bookID}")
    public String deleteBook(@PathVariable("bookID") int bookID)
    {
        bookService.deleteBook(bookID);
        return "Deleted";
    }

    @GetMapping("load")
    public String Load()
    {
        bookService.Load();
        return "Success";
    }
    @GetMapping("Books/author/{author}")
    public List<Book> searchByKey(@PathVariable("author") String author)
    {
        return bookService.searchByKey(author);
    }


}
