package com.rbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rbs.entity.BookStatus;

/**
 * Holds the CRUD operations for {@link BookStatus} entity.
 *
 * @author rburawes
 */
@RepositoryRestResource
public interface BookStatusRepository extends JpaRepository<BookStatus, Long> {
}
