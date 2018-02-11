package com.rbs.repository;

import org.springframework.data.repository.CrudRepository;

import com.rbs.entity.Role;

/**
 * Holds the CRUD operations for {@link Role} entity.
 *
 * @author rburawes
 */
public interface RoleRepository extends CrudRepository<Role, Long>{}
