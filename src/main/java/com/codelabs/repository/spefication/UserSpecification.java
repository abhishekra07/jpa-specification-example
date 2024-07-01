package com.codelabs.repository.spefication;

import com.codelabs.entity.Post;
import com.codelabs.entity.User;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> hasUsername(String username) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), username);
    }

    public static Specification<User> hasEmail(String email) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email);
    }

    public static Specification<User> hasPostContent(String content) {
        return (root, query, criteriaBuilder) -> {
            Join<User, Post> posts = root.join("posts", JoinType.INNER);
            return criteriaBuilder.equal(posts.get("content"), content);
        };
    }

    public static Specification<User> orderByUsernameAsc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("username")));
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<User> orderByUsernameDesc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("username")));
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<User> groupByUsername() {
        return (root, query, criteriaBuilder) -> {
            query.groupBy(root.get("username"));
            return criteriaBuilder.conjunction();
        };
    }
}