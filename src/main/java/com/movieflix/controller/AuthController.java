package com.movieflix.controller;

import com.movieflix.controller.request.UserRequest;
import com.movieflix.controller.response.UserResponse;
import com.movieflix.entity.User;
import com.movieflix.mapper.UserMapper;
import com.movieflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movieflix/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {
        User userSaved = userService.save(UserMapper.toUser(userRequest));
        return new ResponseEntity<>(UserMapper.toUserResponse(userSaved), HttpStatus.CREATED);

    }
}
