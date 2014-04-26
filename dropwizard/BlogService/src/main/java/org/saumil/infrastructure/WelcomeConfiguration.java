package org.saumil.infrastructure;

import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by saumil on 2014/04/25.
 */
public class WelcomeConfiguration extends Configuration {

    @NotNull
    @Valid
    private MessageConfiguration message;

    @NotNull
    @Valid
    private DatabaseConfiguration database;


    public DatabaseConfiguration getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfiguration database) {
        this.database = database;
    }

    public MessageConfiguration getMessage() {
        return message;
    }

    public void setMessage(MessageConfiguration message) {
        this.message = message;
    }
}
