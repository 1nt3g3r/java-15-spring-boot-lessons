package com.java15.springboot.userinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/getUserInfo")
@RestController
public class UserInfoController {
    private final UserInfoService userInfoService;

    @GetMapping
    public UserInfo getUserInfo(@RequestParam String email) {
        return userInfoService.getUserInfo(email);
    }
}
