package com.java15.springboot.useroption;

import com.java15.springboot.useroption.pojo.DeleteOptionRequest;
import com.java15.springboot.useroption.pojo.UserOptionsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/user/option")
@RestController
public class UserOptionController {
    private final UserOptionService userOptionService;

    @GetMapping("/list")
    public List<UserOption> list() {
        return userOptionService.findAll();
    }

    @GetMapping("/getAllForUser")
    public UserOptionsResponse getAllForUser(@RequestParam String username, @RequestParam(required = false) String[] optionQuery) {
        return UserOptionsResponse.success(userOptionService.getAllForUserUsingJdbcTemplate(username, optionQuery));
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody DeleteOptionRequest request) {
        userOptionService.delete(request.getUsername(), request.getOption());

        return true;
    }
}
