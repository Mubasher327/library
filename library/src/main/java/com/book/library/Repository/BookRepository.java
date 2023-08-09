package com.book.library.Repository;

import com.book.library.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    Book findBookByIsbn(Long isbn);
    Book findBookByTitle(String title);
    List<Book> findBookByAuthorName(String authorName);
    List<Book> findBookByUser_Id(Long id);
    List<Book> findBookByLibrarian_Id(Long id);


}
