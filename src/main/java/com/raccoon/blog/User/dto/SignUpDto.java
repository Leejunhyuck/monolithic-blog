package com.raccoon.blog.User.dto;

import com.raccoon.blog.User.domain.Member;
import com.raccoon.blog.User.domain.MemberRole;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class SignUpDto {
    private String id;
    private String password;
    private String name;
    private List<MemberRole> roles;

    public Member toEntity(){
        return Member.builder()
                .uid(id)
                .password(password)
                .uname(name)
                .roles(roles)
                .build();
    }
}
