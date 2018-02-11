package com.rbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Represents the stock status for the books.
 * @author rburawes
 */
@Entity
public class BookStatus extends Modifiable{

    @Column(nullable = false)
    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
