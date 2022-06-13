package com.example.demo.repository;

import com.example.demo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataBoardRepository extends JpaRepository<Board, Long>{

    List<Board> findByTitleContaining(String keyword);
}
