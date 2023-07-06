package com.abdullah.firstsbp.service.serviceImpl;

import com.abdullah.firstsbp.entity.User;
import com.abdullah.firstsbp.repository.UserRepository;
import com.abdullah.firstsbp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public ResponseEntity<?> readUser() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @Override
    public ResponseEntity<?> readUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Id Not Found!");
    }

    @Override
    public ResponseEntity<?> updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());

        if (optionalUser.isPresent()) {
            User user1 = optionalUser.get();
            user1.setFullName(user.getFullName());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());

            userRepository.save(user1);
            return ResponseEntity.status(HttpStatus.OK).body("User Profile Updated Successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Id Not Found!");
    }

    @Override
    public ResponseEntity<?> deleteUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
            return ResponseEntity.status(HttpStatus.OK).body("User Account Deleted Successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Account Not Found!");
    }
}
