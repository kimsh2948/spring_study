package com.example.demo.repository;

import com.example.demo.domain.Board;
import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaBoardRepository implements BoardRepository{

    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board);
        return board;
    }

    @Override
    public Board update(Board board) {
        return null;
    }

    @Override
    public Optional<Board> findById(Board board) {
        return Optional.empty();
    }

    @Override
    public List<Board> findAll() {
        List<Board> result = em.createQuery("select m from Board m", Board.class)
                .getResultList();
        return result;
    }
}
