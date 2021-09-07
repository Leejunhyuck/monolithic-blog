package com.raccoon.blog.MemberShip.application.impl;

import com.raccoon.blog.Board.domain.Board;
import com.raccoon.blog.Board.dto.BoardDto;
import com.raccoon.blog.Board.dto.PageDto;
import org.springframework.data.domain.Page;

public interface MemberShipService {
    public Board saveMemberShip(Board board);
    public Page<Board> getMemberShipList(PageDto pageDto);
    public void deleteMemberShip(BoardDto boardDto);
}
