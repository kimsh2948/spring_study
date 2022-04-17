package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import org.junit.jupiter.api.Test;

public class BoardUpdateTest {
    BoardService boardService;
    BoardRepository boardRepository;

    @Test
    void update(){
        Board board = new Board();
        board.setTitle("test");
        Long id = board.getId();

        boardService.update(id);
    }
}
