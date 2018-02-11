package com.rbs.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.rbs.entity.Book;
import com.rbs.entity.BookStatus;
import com.rbs.repository.BookRepository;
import com.rbs.repository.BookStatusRepository;

/**
 * Handles all the requests for book information.
 *
 * @author rburawes
 */
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookRepository repository;
    private BookStatusRepository statusRepository;

    public BookController(BookRepository repository, BookStatusRepository statusRepository) {
        this.repository = repository;
        this.statusRepository = statusRepository;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN_ACCOUNT') or hasAuthority('USER_ACCOUNT')")
    public Collection<Book> getAllDevices() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/statuses")
    @PreAuthorize("hasAuthority('ADMIN_ACCOUNT') or hasAuthority('USER_ACCOUNT')")
    public Collection<BookStatus> getAllStatuses() {
        return statusRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN_ACCOUNT') or hasAuthority('USER_ACCOUNT')")
    public Book get(@PathVariable(value = "id") long id) {
        return repository.findOne(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN_ACCOUNT')")
    public Book add(@RequestBody Book book) {
        return repository.save(book);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN_ACCOUNT')")
    public Book edit(@RequestBody Book book) {
        return repository.save(book);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN_ACCOUNT')")
    public boolean delete(@PathVariable(value = "id") long id) {
        try {
            repository.delete(repository.findOne(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
