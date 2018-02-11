package com.rbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Holds the {@link Author} details associated with the {@link Book}.
 *
 * @author rburawes
 */
@Entity
public class Author extends Modifiable {

    @Column(name = "given_name", nullable = false)
    private String givenName;

    @Column(name = "family_name", nullable = false)
    private String familyName;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
