package com.raccoon.blog.MemberShip.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name= "membershipledger")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberShipLedger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lno;

    private String membershipName;

    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updateddate;

    @Builder
    MemberShipLedger(Long mno, String membershipName){
        this.lno = lno;
        this.membershipName = membershipName;
    }
}
