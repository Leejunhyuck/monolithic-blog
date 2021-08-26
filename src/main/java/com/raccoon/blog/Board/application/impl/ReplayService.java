package com.raccoon.blog.Board.application.impl;

import com.raccoon.blog.Board.domain.Board;
import com.raccoon.blog.Board.domain.Reply;
import com.raccoon.blog.Board.dto.ReplyDto;

import java.util.List;

public interface ReplayService {
    public List<Reply> register(long bno, ReplyDto replyDto);
    public List<Reply> getListByBoard(long bno);
}
