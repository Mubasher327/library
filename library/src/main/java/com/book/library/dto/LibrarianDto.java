package com.book.library.dto;

import com.book.library.Entity.Librarian;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibrarianDto {

    private long id;
    private String name;
    private String email;

    public LibrarianDto(Librarian librarian){
        this.setId(librarian.getId());
        this.setName(librarian.getName());
        this.setEmail(librarian.getEmail());
    }

    public Librarian dissamble(){
        Librarian librarian=new Librarian();

        librarian.setId(id);
        librarian.setName(name);
        librarian.setEmail(email);
        return librarian;
    }
}
