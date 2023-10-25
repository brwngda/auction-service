package com.example.auctionservice.controller;

import com.example.auctionservice.model.UserEntity;
import com.example.auctionservice.model.request.UserRequest;
import com.example.auctionservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.auctionservice.adapter.UserAdapter.toDto;

@Slf4j
@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    List<UserEntity> getUsers() {
        log.info("Client sent request to get user list");
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    UserEntity getUserById(@PathVariable Long id) {
        log.info("Client sent request to get user with id: {}", id);
        return userService.getUserById(id);
    }

    @PostMapping
    UserRequest addUser(@RequestBody UserRequest userRequest) {
        return toDto(userService.createUser(userRequest));
    }

    @PatchMapping("/{id}")
    UserEntity updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return userService.updateUser(id, userRequest);
    }

    @DeleteMapping("/{id}")
    UserEntity deleteUser(@PathVariable Long id) {
        log.info("Client sent request to delete user with id: {}", id);
        return userService.deleteUser(id);
    }
}
