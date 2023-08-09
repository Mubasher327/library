package com.book.library.Controller;

import com.book.library.Entity.Book;
import com.book.library.Service.BookService;
import com.book.library.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public String addBook(@RequestBody BookDto book){
        bookService.addBook(book);
        return "User Created Successfully";
    }

    @GetMapping("/get")
    public List<Book> getBooks(){
        System.out.println("Get Books");
        return bookService.gattBooks();
    }

    @DeleteMapping("/delete/{id}")
    private String deleteBook(@PathVariable(name = "id") long bookId){
        return bookService.deleteBook(bookId);
    }
}
