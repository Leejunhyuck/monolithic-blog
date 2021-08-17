package com.raccoon.blog.user.controller.v1;

import com.raccoon.blog.global.config.jwt.JwtTokenProvider;
import com.raccoon.blog.user.application.impl.UserService;
import com.raccoon.blog.user.domain.Member;
import com.raccoon.blog.user.dto.ReqDto;
import com.raccoon.blog.user.dto.SignInDto;
import com.raccoon.blog.user.dto.SignUpDto;
import com.raccoon.blog.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/user/*")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final MemberRepository memberRepository;
    private final UserService userService;

    @GetMapping("admin/users")
    public Iterable<Member> allUsers() {
        return memberRepository.findAll();
    }

    @PostMapping("signup")
    public ResponseEntity<Member> signUp (@RequestBody SignUpDto signUpDto){
        return new ResponseEntity<>(userService.signUp(signUpDto),HttpStatus.CREATED);
    }

    @PostMapping("signin")
    public ResponseEntity<ReqDto> signIn (@RequestBody SignInDto signDto){
        return new ResponseEntity<>(userService.signIn(signDto),HttpStatus.CREATED);
    }
}