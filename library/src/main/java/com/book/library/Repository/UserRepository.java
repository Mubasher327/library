package com.book.library.Repository;

import com.book.library.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByName(String name);
    User findUserByEmail(String email);

}
