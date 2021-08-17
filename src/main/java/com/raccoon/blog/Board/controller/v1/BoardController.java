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

@RequestMapping("api/v1/board/*")
@CrossOrigin
@RestController
@RequiredArgsConstructor
@Log
public class BoardController {
    private final BoardRepository repo;
    private final BoardService boardService;

    @PostMapping("register")
    public ResponseEntity<Board> register(@RequestBody BoardDto boardDto) {
        log.info("REGISTER BOARD" + boardDto);
        return new ResponseEntity<>(boardService.register(boardDto.toEntity()), HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<Page> getList(PageDto pageDto) {
        log.info("GET BOARD LIST" + pageDto);

        return new ResponseEntity<>(boardService.getList(pageDto), HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity delete(@RequestBody BoardDto boardDto) {
        log.info("DELETE BOARD");

        boardService.delete(boardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("modify")
    public ResponseEntity<Page> modify(@RequestBody BoardDto boardDto) {
        log.info("MODIFY BOARD" );

        boardService.modify(boardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("view")
    public ResponseEntity<Board> view(Long bno) {
        log.info("BNO: " + bno);


        return new ResponseEntity<>(boardService.view(bno), HttpStatus.OK);
    }

}
