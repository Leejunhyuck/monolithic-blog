package com.raccoon.blog.user.application.impl;

import com.raccoon.blog.user.domain.Member;
import com.raccoon.blog.user.dto.ReqDto;
import com.raccoon.blog.user.dto.SignInDto;
import com.raccoon.blog.user.dto.SignUpDto;

public interface UserService {
    public Member signUp(SignUpDto signUpDto);
    public ReqDto signIn(SignInDto signInDto);
}
