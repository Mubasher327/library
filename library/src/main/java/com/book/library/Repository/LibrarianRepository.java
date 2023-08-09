package com.book.library.Repository;

import com.book.library.Entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
}
