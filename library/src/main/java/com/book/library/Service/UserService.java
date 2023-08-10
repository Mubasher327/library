package com.book.library.Service;

import com.book.library.Entity.Librarian;
import com.book.library.Entity.User;
import com.book.library.Repository.UserRepository;
import com.book.library.dto.BookDto;
import com.book.library.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }
    public String deleteUser(long userId) {
        userRepository.deleteById(userId);
        return "User deleted Successfully";
    }

    public UserDto findUser(String name, String email){
        User user =new User();

        if (name!=null){
            user=userRepository.findUserByName(name);
        }
        else if(email!=null){
            user=userRepository.findUserByEmail(email);
        }
        else{
            System.out.printf("Credntials invalid!!");
        }
        return new UserDto(user);
    }

}
