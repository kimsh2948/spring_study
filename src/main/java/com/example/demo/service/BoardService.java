package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.SpringDataBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BoardService {

    private final SpringDataBoardRepository boardRepository;

    @Autowired
    public BoardService(SpringDataBoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long join(Board board){
        boardRepository.save(board);

        return board.getId();
    }

    public Optional<Board> update(Long id) {
        Optional<Board> board = boardRepository.findById(id);

        return board;
    }

    public void delete(Long id){
        boardRepository.deleteById(id);
    }

    public List<Board> findBoard() {
        return boardRepository.findAll();
    }

    public Optional<Board> findOne(Long boardId) { return boardRepository.findById(boardId); }
}
