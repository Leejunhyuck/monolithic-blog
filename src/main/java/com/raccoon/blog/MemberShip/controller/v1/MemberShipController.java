package com.raccoon.blog.MemberShip.controller.v1;

import com.raccoon.blog.MemberShip.application.impl.MemberShipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/memberships/*")
@RequiredArgsConstructor
@Log
public class MemberShipController {
    private final MemberShipService memberShipService;

    @GetMapping
    public ResponseEntity<String> getMemberShipList(){
        return new ResponseEntity<>("hello", HttpStatus.CREATED);
    }

    @GetMapping("{/userId}")
    public ResponseEntity<String> getUserMemberShipList(@PathVariable String userId){
        return new ResponseEntity<>("hello", HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<String> saveMemberShip(){
       return new ResponseEntity<>("hello", HttpStatus.CREATED);
    }

    @DeleteMapping("/{mno}")
    public ResponseEntity<String> deleteMembership(@PathVariable Long mno){
        return new ResponseEntity<>("hello", HttpStatus.CREATED);
    }
}
