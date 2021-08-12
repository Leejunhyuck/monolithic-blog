package com.raccoon.blog.Board.application.impl;

import com.raccoon.blog.Board.domain.Board;
import com.raccoon.blog.Board.dto.BoardDto;
import com.raccoon.blog.Board.dto.PageDto;
import com.raccoon.blog.Board.repository.BoardRepository;
import com.raccoon.blog.Board.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log
public class BoardServiceImpl implements BoardService{
    private final BoardRepository repo;

    @Override
    public Board register(Board board) {
        return repo.save(board);
    }

    @Override
    public Page<Board> getList(PageDto pageDto) {
        PageVO pageVO = PageVO.builder()
                .page(pageDto.getPage())
                .size(pageDto.getSize())
                .keyword(pageDto.getKeyword())
                .type(pageDto.getType())
                .build();

        Pageable page = pageVO.makePageable(0, "bno");
        Page<Board> result = repo.findAll(repo.makePredicate(pageDto.getType(), pageDto.getKeyword()), page);

        log.info("" + page);
        log.info("" + result);
        log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());

        return result;
    }

    @Override
    public Page<Board> delete(Long bno, PageDto pageDto) {
        repo.deleteById(bno);

        PageVO pageVO = PageVO.builder()
                .page(pageDto.getPage())
                .size(pageDto.getSize())
                .keyword(pageDto.getKeyword())
                .type(pageDto.getType())
                .build();

        Pageable page = pageVO.makePageable(0, "bno");
        Page<Board> result = repo.findAll(repo.makePredicate(pageDto.getType(), pageDto.getKeyword()), page);

        return result;
    }

    @Override
    public Page<Board> modify(BoardDto boardDto, PageDto pageDto) {
        repo.findById(boardDto.getBno()).ifPresent(origin -> {

            origin.modifyBoard(boardDto.getTitle(), boardDto.getContent(), boardDto.getWriter());

            repo.save(origin);

        });

        PageVO pageVO = PageVO.builder()
                .page(pageDto.getPage())
                .size(pageDto.getSize())
                .keyword(pageDto.getKeyword())
                .type(pageDto.getType())
                .build();

        Pageable page = pageVO.makePageable(0, "bno");
        Page<Board> result = repo.findAll(repo.makePredicate(pageDto.getType(), pageDto.getKeyword()), page);

        return result;
    }

    @Override
    public Board view(Long bno) {
        Board board = repo.findById(bno).orElseThrow(() -> new IllegalArgumentException("no such data"));

        return board;
    }
}
