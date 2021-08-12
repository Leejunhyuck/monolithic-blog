package com.raccoon.blog.Board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Entity
@Table(name = "webreplies")
@EqualsAndHashCode(of = "rno")
@ToString(exclude = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String replyText;

    private String replyer;

    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updatedate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Builder
    Reply(String replyText, String replyer, Board board) {
        this.replyText = replyText;
        this.replyer = replyer;
        this.board = board;
    }

    public void modifyReply (String replyText, String replyer){
        this.replyText = replyText;
        this.replyer = replyer;
    }
}
