package com.book.library.Service;

import com.book.library.Entity.Book;
import com.book.library.Entity.Librarian;
import com.book.library.Entity.User;
import com.book.library.Repository.BookRepository;
import com.book.library.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibrarianService librarianService;

    public BookDto addBook(BookDto book) {
        Librarian librarian = librarianService.getLibrarianEntity(book.getLibrarianDto().getId());
        return new BookDto(bookRepository.save(book.dissamble()));
    }

    public List<BookDto> getBooks() {
        return bookRepository.findAll().stream().map(BookDto::new).collect(Collectors.toList());
    }

    public String deleteBook(long bookId) {
        bookRepository.deleteById(bookId);
        return "Successfully book deleted";
    }

    public BookDto findBook(Long isbn, String title) {
        Book book = new Book();
        if (isbn != null) {
            book = bookRepository.findBookByIsbn(isbn);
        } else if (title != null) {
            book = bookRepository.findBookByTitle(title);
        } else {
            System.out.println("credential invalid!!");
        }

        return new BookDto(book);
    }

    public List<BookDto> findBookList(Long userId, Long librarianId, String authorName) {
        List<BookDto> bookList = new ArrayList<>();
        if (userId != null) {
            bookList = bookRepository.findBookByUser_Id(userId).stream().map(BookDto::new).collect(Collectors.toList());

        } else if (librarianId != null) {
            bookList = bookRepository.findBookByLibrarian_Id(librarianId).stream().map(BookDto::new).collect(Collectors.toList());

        } else if (authorName != null) {
            bookList = bookRepository.findBookByAuthorName(authorName).stream().map(BookDto::new).collect(Collectors.toList());
        } else {
            System.out.println("Credential invalid!!");
        }
        return bookList;
    }

}
