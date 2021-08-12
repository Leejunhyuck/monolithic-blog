package com.raccoon.blog.Board.application.impl;

import com.raccoon.blog.Board.domain.Board;
import com.raccoon.blog.Board.dto.BoardDto;
import com.raccoon.blog.Board.dto.PageDto;
import org.springframework.data.domain.Page;

public interface BoardService  {
    public Board register(Board board);
    public Page<Board> getList(PageDto pageDto);
    public Page<Board> delete(Long bno, PageDto pageDto);
    public Page<Board> modify(BoardDto boardDto, PageDto pageDto);
    public Board view(Long bno);
}
