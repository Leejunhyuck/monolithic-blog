package com.raccoon.blog.User.application.impl;

import com.raccoon.blog.User.domain.Member;
import com.raccoon.blog.User.dto.ReqDto;
import com.raccoon.blog.User.dto.SignInDto;
import com.raccoon.blog.User.dto.SignUpDto;

public interface UserService {
    public Member signUp(SignUpDto signUpDto);
    public ReqDto signIn(SignInDto signInDto);
}
