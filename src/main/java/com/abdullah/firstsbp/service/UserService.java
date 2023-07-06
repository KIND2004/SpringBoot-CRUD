package com.abdullah.firstsbp.service;

import com.abdullah.firstsbp.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void saveUser(User user);

    ResponseEntity<?> readUser();

    ResponseEntity<?> readUserById(long id);

    ResponseEntity<?> updateUser(User user);

    ResponseEntity<?> deleteUser(long id);
}
