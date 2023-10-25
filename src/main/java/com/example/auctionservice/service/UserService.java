package com.example.auctionservice.service;

import com.example.auctionservice.exception.NoUserFoundException;
import com.example.auctionservice.model.UserEntity;
import com.example.auctionservice.model.request.UserRequest;
import com.example.auctionservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

import static com.example.auctionservice.adapter.UserAdapter.toEntity;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoUserFoundException(id));
    }

    public UserEntity createUser(UserRequest userRequest) {
        UserEntity entity = toEntity(userRequest);
        return userRepository.save(entity);
    }

    public UserEntity updateUser(Long id, UserRequest userRequest) {
        UserEntity userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new NoUserFoundException(id));
        UserEntity updatedUser = toEntity(id, userRequest);
        return userRepository.save(updatedUser);
    }

    public UserEntity deleteUser(Long id) {
        UserEntity userFromDb = userRepository.findById(id)
                .orElseThrow(() -> new NoUserFoundException(id));
        userRepository.delete(userFromDb);
        return userFromDb;
    }

}
