package com.raccoon.blog.Board.application.impl;

import com.raccoon.blog.Board.domain.Board;
import com.raccoon.blog.Board.domain.Reply;
import com.raccoon.blog.Board.dto.ReplyDto;
import com.raccoon.blog.Board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplayServiceImpl implements ReplayService{
    private final ReplyRepository replyRepo;

    @Override
    public List<Reply> getListByBoard(long bno) throws RuntimeException{
        Board board = Board.builder()
                .bno(bno)
                .build();

        return replyRepo.getRepliesOfBoard(board);
    }

    @Override
    public List<Reply> register(long bno, ReplyDto replyDto) {

        Board board = Board.builder()
                .bno(bno)
                .build();

        Reply reply = Reply.builder()
                .replyer(replyDto.getReplyer())
                .replyText(replyDto.getReplyText())
                .board(board)
                .build();

        replyRepo.save(reply);

        return getListByBoard(bno);
    }
}
