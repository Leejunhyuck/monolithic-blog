package com.raccoon.blog.User.controller.v1;

import com.raccoon.blog.User.application.impl.UserService;
import com.raccoon.blog.User.domain.Member;
import com.raccoon.blog.User.dto.ReqDto;
import com.raccoon.blog.User.dto.SignInDto;
import com.raccoon.blog.User.dto.SignUpDto;
import com.raccoon.blog.User.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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