package com.rbs.entity.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.rbs.entity.Modifiable;
import com.rbs.entity.Persistable;

/**
 * Sets the dates for {@link Persistable#timeCreated} and {@link Modifiable#timeUpdated}.
 *
 * @author rburawes
 */
public class TimestampListener {

    /**
     * Sets the entity time before the persist process.
     */
    @PrePersist
    public void prePersist(Persistable persistable) {
        persistable.setTimeCreated(new Date());
    }

    /**
     * Sets the entity timeF before the update process.
     */
    @PreUpdate
    public void preUpdate(Modifiable modifiable) {
        modifiable.setTimeUpdated(new Date());
    }
}
