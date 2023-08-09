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
    public List<BookDto> getBooks(){
        System.out.println("Get Books");
        return bookService.getBooks();
    }

    @DeleteMapping("/delete/{id}")
    private String deleteBook(@PathVariable(name = "id") long bookId){
        return bookService.deleteBook(bookId);
    }

    @GetMapping("/search")
    private BookDto findBook(@RequestParam(name = "isbn",required = false)Long isbn , @RequestParam(name = "title",required = false)String title){
        return bookService.findBook(isbn, title);
    }
    @GetMapping("/search/list")
    private List<BookDto> findBooklist(@RequestParam(name = "userId",required = false)Long userId ,
                                       @RequestParam(name = "librarianId",required = false)Long librarianId,
                                       @RequestParam(name="authorName",required = false)String authorName){
        return bookService.findBookList(userId,librarianId,authorName);
    }

}
