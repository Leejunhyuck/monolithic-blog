package com.raccoon.blog.MemberShip.application.impl;

import com.raccoon.blog.Board.domain.Board;
import com.raccoon.blog.Board.dto.BoardDto;
import com.raccoon.blog.Board.dto.PageDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class MemberShipServiceImpl implements MemberShipService{

    @Override
    public Board saveMemberShip(Board board) {
        return null;
    }

    @Override
    public Page<Board> getMemberShipList(PageDto pageDto) {
        return null;
    }

    @Override
    public void deleteMemberShip(BoardDto boardDto) {

    }
}
