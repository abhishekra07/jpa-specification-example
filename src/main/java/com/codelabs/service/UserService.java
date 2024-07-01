package com.codelabs.service;

import com.codelabs.entity.User;
import com.codelabs.repository.UserRepository;
import com.codelabs.repository.spefication.UserSpecification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsersWithUsername(String username) {
        return userRepository.findAll(UserSpecification.hasUsername(username));
    }

    public List<User> getUsersWithEmail(String email) {
        return userRepository.findAll(UserSpecification.hasEmail(email));
    }

    public List<User> getUsersWithPostContent(String content) {
        return userRepository.findAll(UserSpecification.hasPostContent(content));
    }

    public List<User> getUsersOrderedByUsernameAsc() {
        return userRepository.findAll(UserSpecification.orderByUsernameAsc());
    }

    public List<User> getUsersOrderedByUsernameDesc() {
        return userRepository.findAll(UserSpecification.orderByUsernameDesc());
    }

    public List<User> getUsersGroupedByUsername() {
        return userRepository.findAll(UserSpecification.groupByUsername());
    }
}