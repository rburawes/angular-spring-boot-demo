package com.rbs.entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbs.entity.listener.TimestampListener;

/**
 * Represents the object that can be updated.
 *
 * @author rburawes
 */
@MappedSuperclass
@EntityListeners(value = TimestampListener.class)
public class Modifiable extends Persistable {

    /**
     * The date and time that the object was last updated. Serves as the version control of locking and concurrency.
     */
    @Version
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_updated")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeUpdated;

    /**
     * Returns the date and time of the entity's last update.
     *
     * @return timeUpdated
     */
    public Date getTimeUpdated() {
        return timeUpdated;
    }

    /**
     * Sets the date and time of the entity's last update.
     */
    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }
}
