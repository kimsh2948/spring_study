package com.example.demo.repository;

import com.example.demo.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository {
    Board save(Board board);
    Board update(Board board);
    Optional<Board> findById(Long id);
    List<Board> findAll();
    Optional<Board> findOne();
}
