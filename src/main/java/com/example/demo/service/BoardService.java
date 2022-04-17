package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long join(Board board){
        boardRepository.save(board);

        return board.getId();
    }

    public Optional<Board> update(Long boardId) {
        Optional<Board> board = boardRepository.findById(boardId);

        return board;
    }

    public List<Board> findBoard() {
        return boardRepository.findAll();
    }

    public Optional<Board> findOne(Long boardId) { return boardRepository.findById(boardId); }
}
