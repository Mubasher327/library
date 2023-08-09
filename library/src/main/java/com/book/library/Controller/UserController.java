package com.book.library.Controller;

import com.book.library.Entity.User;
import com.book.library.Service.UserService;
import com.book.library.dto.UserDto;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public String createUser(@RequestBody UserDto user){
        userService.createUser(user);
        return "User Created Successfully";
    }

    @GetMapping("/get")
    public List<User> getUsers(){
        System.out.println("Get Users");
        return userService.getUsers();
    }

    @DeleteMapping("/delete/{id}")
    private String deleteUser(@PathVariable(name = "id") long userId){
        return userService.deleteUser(userId);
    }
}
