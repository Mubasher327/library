package com.book.library.Service;

import com.book.library.Entity.Book;
import com.book.library.Entity.Librarian;
import com.book.library.Entity.User;
import com.book.library.Repository.BookRepository;
import com.book.library.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibrarianService librarianService;

    public BookDto addBook(BookDto book) {
        Librarian librarian=librarianService.getLibrarianEntity(book.getLibrarianDto().getId());
        return new BookDto(bookRepository.save(book.dissamble()));
    }

    public List<Book> gattBooks() {
        return bookRepository.findAll();
    }

    public String deleteBook(long bookId) {
        bookRepository.deleteById(bookId);
        return "Successfully book deleted";
    }
}
