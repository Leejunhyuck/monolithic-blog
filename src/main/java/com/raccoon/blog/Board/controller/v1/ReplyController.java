package com.raccoon.blog.Board.controller.v1;

import com.raccoon.blog.Board.application.impl.ReplayService;
import com.raccoon.blog.Board.domain.Board;
import com.raccoon.blog.Board.domain.Reply;
import com.raccoon.blog.Board.dto.ReplyDto;
import com.raccoon.blog.Board.repository.BoardRepository;
import com.raccoon.blog.Board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("api/v1/replies/*")
@RequiredArgsConstructor
@CrossOrigin
@Log
public class ReplyController {
    private final ReplyRepository replyRepo;
    private final ReplayService replayService;

    @GetMapping("/{bno}")
    public ResponseEntity<List<Reply>> getReplies(@PathVariable("bno") Long bno){
        log.info("GET ALL REPLIES");
        return new ResponseEntity<>(replayService.getListByBoard(bno),HttpStatus.OK );
    }

    @Transactional
    @PostMapping("/{bno}")
    public ResponseEntity<List<Reply>> addReply(@PathVariable("bno") Long bno, @RequestBody ReplyDto replyDto){
        log.info("ADD REPLAY");
        log.info("BNO: " + bno);
        log.info("REPLY: " + replyDto);

        return new ResponseEntity<>(replayService.register(bno, replyDto), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{bno}/{rno}")
    public ResponseEntity<List<Reply>> remove(
            @PathVariable("bno")Long bno,
            @PathVariable("rno")Long rno){
        log.info("DELETE REPLY"+ rno);
        return new ResponseEntity<>(replayService.delete(bno, rno), HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/{bno}")
    public ResponseEntity<List<Reply>> modify(@PathVariable("bno")Long bno,
                                              @RequestBody ReplyDto replyDto){
        log.info("modify reply: "+ replyDto);
        return new ResponseEntity<>(replayService.modify(bno, replyDto), HttpStatus.OK);
    }

    private List<Reply> getListByBoard(Board board) throws RuntimeException{
        log.info("getListByBoard...." + board);
        return replyRepo.getRepliesOfBoard(board);
    }
}
