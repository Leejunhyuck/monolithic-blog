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
    private final BoardRepository boardRepository;

    @Override
    public Board register(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Page<Board> getList(PageDto pageDto) {
        PageVO pageVO = pageDto.toEntity();

        Pageable page = pageVO.makePageable(0, "bno");
        Page<Board> result = boardRepository.findAll(boardRepository.makePredicate(pageDto.getType(), pageDto.getKeyword()), page);

        log.info("" + page);
        log.info("" + result);
        log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());

        return result;
    }

    @Override
    public void delete(BoardDto boardDto) {
        Board board = boardRepository.findById(boardDto.getBno())
                .orElseThrow(() -> new IllegalArgumentException("no such data"));

        boardRepository.deleteById(boardDto.getBno());
    }

    @Override
    public void modify(BoardDto boardDto) {
        //ifPresernt-get -> Else or orElse 로 대체
        /*
        boardRepository.findById(boardDto.getBno()).ifPresent(origin -> {

            origin.modifyBoard(boardDto.getTitle(), boardDto.getContent(), boardDto.getWriter());

            boardRepository.save(origin);

        });
        */

        Board board = boardRepository.findById(boardDto.getBno())
                .orElseThrow(() -> new IllegalArgumentException("no such data"));

        board.modifyBoard(boardDto.getTitle(), boardDto.getContent());

        boardRepository.save(board);
    }

    @Override
    public Board view(Long bno) {
        Board board = boardRepository.findById(bno).orElseThrow(() -> new IllegalArgumentException("no such data"));

        return board;
    }
}
