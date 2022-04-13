package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

//    @GetMapping("/board")
//    public String createForm() { return "/board/boardList"; }
    @GetMapping("/board")
    public String list(Model model){

        List<Board> boards = boardService.findBoard();
        model.addAttribute("boards", boards);

        return "/board/boardList";
    }

    @GetMapping("/board/write")
    public String createWriteForm() { return "/board/boardWrite"; }

    @PostMapping("/board/write")
    public String write(BoardWriteForm boardWriteForm) {
        Board board = new Board();
        board.setTitle(boardWriteForm.getTitle());
        board.setWriter(boardWriteForm.getWriter());
        board.setContent(boardWriteForm.getContent());
        board.setDeleteYn('N');
        board.setHits(0);
        board.setCreateDate(LocalDateTime.now());

        boardService.join(board);

        return "redirect:/board";
    }

    @GetMapping("/board/detail")
    public String detail(Model model, @RequestParam("id") Long id) {
        Board boardOne = boardService.findOne(id).get();
        model.addAttribute("boardOne", boardOne);

        return "/board/boardDetail";
    }

    @PostMapping("/board/delete")
    public String delete(@RequestParam() Long id) {
        try {

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/board";
    }

}
