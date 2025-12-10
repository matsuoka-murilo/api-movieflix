package com.movieflix.mapper;

import com.movieflix.controller.request.UserRequest;
import com.movieflix.controller.response.UserResponse;
import com.movieflix.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest userRequest) {
        return User.builder()
                .email(userRequest.email())
                .name(userRequest.name())
                .password(userRequest.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();

    }
}
