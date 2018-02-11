package com.rbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbs.entity.User;

/**
 * Holds the CRUD operations for {@link User} entity.
 *
 * @author rburawes
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
