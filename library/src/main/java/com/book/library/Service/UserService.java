package com.book.library.Service;

import com.book.library.Entity.Librarian;
import com.book.library.Entity.User;
import com.book.library.Repository.UserRepository;
import com.book.library.dto.BookDto;
import com.book.library.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    LibrarianService librarianService;

    public UserDto createUser(UserDto user) {
        //  user.setPassword(passwordEncoder.encode(user.getPassword()));
        Librarian librarian=librarianService.getLibrarianEntity(user.getLibrarianDto().getId());
        return new UserDto(userRepository.save(user.dissamble()));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public String deleteUser(long userId) {
        userRepository.deleteById(userId);
        return "User deleted Successfully";
    }

}
