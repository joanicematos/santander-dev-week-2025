package com.reis.service.impi;

import com.reis.domain.model.User;
import com.reis.domain.repository.UserRepository;
import com.reis.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpi implements UserService {

    private  final UserRepository userRepository;

    public UserServiceImpi(UserRepository userRepository) {
        this.userRepository =  userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoClassDefFoundError::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
