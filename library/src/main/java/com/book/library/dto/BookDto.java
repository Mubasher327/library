package com.book.library.dto;

import com.book.library.Entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private long id;
    private long isbn;
    private String title;
    private String authorName;
    private String category;
    private LibrarianDto librarianDto;

    public BookDto(Book book){

        this.setId(book.getId());
        this.setIsbn(book.getIsbn());
        this.setTitle(book.getTitle());
        this.setAuthorName(book.getAuthorName());
        this.setCategory(book.getCategory());
        this.setLibrarianDto(new LibrarianDto(book.getLibrarian()));
    }

    public Book dissamble(){

        Book book=new Book();
        book.setId(id);
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthorName(authorName);
        book.setCategory(category);
        book.setLibrarian(this.librarianDto.dissamble());
        return book;
    }
}
