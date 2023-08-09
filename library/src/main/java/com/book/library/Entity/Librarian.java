package com.book.library.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Librarian")
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private long id;
    @Column(name="Librarian")
    private String name;
    @Column(name="Email")
    private String email;

    @OneToMany(mappedBy = "librarian")
    private List<Book> books;

    @OneToMany(mappedBy = "librarian")
    private List<User> users;
}
