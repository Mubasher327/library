package com.book.library.dto;

import com.book.library.Entity.Librarian;
import com.book.library.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private long id;
    private String name;
    private String email;
    private LibrarianDto librarianDto;

    public UserDto(User user){
        this.setId(user.getId());
        this.setName(user.getName());
        this.setEmail(user.getEmail());
        this.setLibrarianDto(new LibrarianDto(user.getLibrarian()));
    }

    public User dissamble(){

        User user = new User();

        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setLibrarian(this.librarianDto.dissamble());

        return user;
    }
}
