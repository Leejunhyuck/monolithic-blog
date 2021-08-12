package com.raccoon.blog.user.application.impl;

import com.raccoon.blog.global.config.jwt.JwtTokenProvider;
import com.raccoon.blog.user.domain.Member;
import com.raccoon.blog.user.dto.ReqDto;
import com.raccoon.blog.user.dto.SignInDto;
import com.raccoon.blog.user.dto.SignUpDto;
import com.raccoon.blog.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder pwEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwttokenprovider;

    @Override
    public Member signUp(SignUpDto signUpDto) {
        String encryptPw = pwEncoder.encode(signUpDto.getPassword());

        Member member = Member.builder()
                .uid(signUpDto.getId())
                .uname(signUpDto.getName())
                .password(encryptPw)
                .roles(signUpDto.getRoles())
                .build();

        return memberRepository.save(member);
    }

    @Override
    public ReqDto signIn(SignInDto signInDto) {

        Member user = memberRepository.findById(signInDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("no such data"));

        UsernamePasswordAuthenticationToken authenticator = new UsernamePasswordAuthenticationToken(signInDto.getId(), signInDto.getPassword());
        authenticationManager.authenticate(authenticator);

        if (!pwEncoder.matches(signInDto.getPassword(), user.getPassword()))
            throw new IllegalArgumentException("no such data");

        List<String> list = new ArrayList<String>();
        user.getRoles().forEach(role -> list.add(role.getRoleName()));
        String token =jwttokenprovider.createToken(user.getUid(), list);

        ReqDto reqDto = new ReqDto(user.getName(),token);

        return reqDto;
    }


}
