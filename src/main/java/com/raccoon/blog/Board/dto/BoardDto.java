package com.raccoon.blog.Board.dto;

import com.raccoon.blog.Board.domain.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
    private Long bno;
    private String title;
    private String content;
    private String writer;

    public Board toEntity(){
        return Board.builder()
                .bno(bno)
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}