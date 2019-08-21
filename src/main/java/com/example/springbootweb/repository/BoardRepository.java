package com.example.springbootweb.repository;

import com.example.springbootweb.domain.Board;
import com.example.springbootweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
