package com.example.auctionservice.adapter;

import com.example.auctionservice.model.UserEntity;
import com.example.auctionservice.model.request.UserRequest;

public final class UserAdapter {
    private UserAdapter() {
    }

    public static UserRequest toDto(UserEntity userEntity) {
        return new UserRequest(userEntity);
    }

    public static UserEntity toEntity(UserRequest userRequest) {
        return new UserEntity(userRequest);
    }

    public static UserEntity toEntity(Long id, UserRequest userRequest) {
        UserEntity entity = toEntity(userRequest);
        entity.setUserId(id);
        return entity;
    }
}
