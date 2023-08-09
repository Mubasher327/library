package com.book.library.Service;

import com.book.library.Entity.Librarian;
import com.book.library.Repository.LibrarianRepository;
import com.book.library.dto.LibrarianDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibrarianService {
    @Autowired
    LibrarianRepository librarianRepository;

    public LibrarianDto createLibrarian(LibrarianDto librarianDto) {
        return new LibrarianDto(librarianRepository.save(librarianDto.dissamble()));
    }

    public List<LibrarianDto> getLibrarian() {
        return librarianRepository.findAll().stream().map(LibrarianDto :: new).collect(Collectors.toList());
    }

    public String deleteLibrarianAccount(long librarianId) {
        librarianRepository.deleteById(librarianId);
        return"Successfully librarian account deleted";
    }
    public Librarian getLibrarianEntity(long id){
        return librarianRepository.findById(id).get();
    }
}
