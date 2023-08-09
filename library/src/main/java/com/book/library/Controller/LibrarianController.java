package com.book.library.Controller;

import com.book.library.Entity.Book;
import com.book.library.Entity.Librarian;
import com.book.library.Service.LibrarianService;
import com.book.library.dto.BookDto;
import com.book.library.dto.LibrarianDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Librarian")
public class LibrarianController {
    @Autowired
    LibrarianService librarianService;
    @PostMapping
    public String createLibrarianAccount(@RequestBody LibrarianDto librarianDto){
        librarianService.createLibrarian(librarianDto);
        return "User Created Successfully";
    }

    @GetMapping("/get")
    public List<Librarian> getLibrarian(){
        return librarianService.getLibrarian();
    }

    @DeleteMapping("/delete/{id}")
    private String deleteLibrarian(@PathVariable(name = "id") long librarianId){
        return librarianService.deleteLibrarianAccount(librarianId);
    }
}
