package com.raccoon.blog.MemberShip.controller.v1;

import com.raccoon.blog.MemberShip.application.impl.MemberShipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/membership/*")
@RequiredArgsConstructor
@Log
public class MemberShipController {
    private final MemberShipService memberShipService;
}
