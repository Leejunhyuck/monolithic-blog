package com.raccoon.blog.Board.controller.v1;

import com.raccoon.blog.Board.application.impl.BoardService;
import com.raccoon.blog.Board.domain.Board;
import com.raccoon.blog.Board.dto.BoardDto;
import com.raccoon.blog.Board.dto.PageDto;
import com.raccoon.blog.Board.repository.BoardRepository;
import com.raccoon.blog.Board.vo.PageMaker;
import com.raccoon.blog.Board.vo.PageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/boards/*")
@CrossOrigin
@RestController
@RequiredArgsConstructor
@Log
public class BoardController {
    private final BoardRepository repo;
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Board> saveBoard(@RequestBody BoardDto boardDto) {
        log.info("REGISTER BOARD" + boardDto);
        return new ResponseEntity<>(boardService.register(boardDto.toEntity()), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page> getBoardList(PageDto pageDto) {
        log.info("GET BOARD LIST" + pageDto);

        return new ResponseEntity<>(boardService.getList(pageDto), HttpStatus.OK);
    }

    @DeleteMapping("/{bno}")
    public ResponseEntity deleteBoard(@PathVariable Long id, @RequestBody BoardDto boardDto) {
        log.info("DELETE BOARD");

        boardService.delete(boardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{bno}")
    public ResponseEntity<Page> updateBoard(@PathVariable Long bno, @RequestBody BoardDto boardDto) {
        log.info("MODIFY BOARD" );

        boardService.modify(boardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{bno}")
    public ResponseEntity<Board> view(@PathVariable Long bno) {
        log.info("BNO: " + bno);
        return new ResponseEntity<>(boardService.view(bno), HttpStatus.OK);
    }

}
