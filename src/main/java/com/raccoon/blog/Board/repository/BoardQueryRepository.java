package com.raccoon.blog.Board.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.raccoon.blog.Board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.raccoon.blog.Board.domain.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<Board> findByBno(Long bno) {
        return jpaQueryFactory.selectFrom(board)
                .where(board.bno.eq(bno))
                .fetch();
    }
}
