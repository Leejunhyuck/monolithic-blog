package com.raccoon.blog.Board.dto;

import com.raccoon.blog.Board.domain.Board;
import com.raccoon.blog.Board.vo.PageVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDto {
    private int page;
    private int size;
    private String keyword;
    private String type;

    public PageVO toEntity(){
        return PageVO.builder()
                .page(page)
                .size(size)
                .keyword(keyword)
                .type(type)
                .build();
    }
}