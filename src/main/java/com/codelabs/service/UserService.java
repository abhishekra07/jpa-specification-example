package com.codelabs.service;

import com.codelabs.entity.User;
import com.codelabs.repository.UserRepository;
import com.codelabs.repository.spefication.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersWithUsername(String username) {
        Specification<User> userSpecification = UserSpecification.hasUsername(username);
        return userRepository.findAll(userSpecification);
    }

    public List<User> getUsersWithEmail(String email) {
        Specification<User> userSpecification = UserSpecification.hasEmail(email);
        return userRepository.findAll(userSpecification);
    }

    public List<User> getUsersWithPostContent(String content) {
        Specification<User> userSpecification = UserSpecification.hasPostContent(content);
        return userRepository.findAll(userSpecification);
    }
}