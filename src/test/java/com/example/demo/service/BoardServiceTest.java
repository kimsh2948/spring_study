package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardServiceTest {
    BoardService boardService;
    BoardRepository boardRepository;

    @Test
    void findOne() {
        Long id = 2L;
        Board teboard = new Board();

        teboard.setTitle("테스트");

        Board reboard = boardService.findOne(id).get();

        assertEquals(teboard.getTitle(), reboard.getTitle());

    }
}
