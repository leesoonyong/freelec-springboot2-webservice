package com.jojodu.book.springboot.domain.user;

import com.jojodu.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
