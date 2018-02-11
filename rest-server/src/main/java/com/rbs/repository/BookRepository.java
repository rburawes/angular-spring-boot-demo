package com.rbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rbs.entity.Book;

/**
 * Holds the CRUD operations for {@link Book} entity.
 *
 * @author rburawes
 */
@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long> {
}
